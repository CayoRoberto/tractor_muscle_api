package com.example.tractor_muscle_api.service.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;


import com.example.tractor_muscle_api.domain.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    // Dizer ao spring para que ele leia a variavel do aplication.properties e add
    // no atributo secret
    @Value("${api.security.token.secret}")
    private String secret;

//    private String secretParaEmail = "123456";

//    @Value("${jwt.expiration}")
//    private String jwtSecret = "123456";

    public String gerarToken(Usuario usuario){
        System.out.println("JWT Secret: " + secret);
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return  JWT.create()
                    .withIssuer("API tractor_muscle")
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    //.withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token jwt", exception);
        }
    }

//    public String gerarTokenEmail(Usuario usuario){
//        System.out.println("JWT Secret: " + secretParaEmail);
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(secretParaEmail);
//            return  JWT.create()
//                    .withIssuer("API de_olha_na_cidade")
//                    .withSubject(usuario.getEmail())
//                    .withClaim("id", usuario.getId())
//                    .withExpiresAt(dataEmailExpiracao())
//                    .sign(algorithm);
//        } catch (JWTCreationException exception){
//            throw new RuntimeException("Erro ao gerar token jwt", exception);
//        }
//    }

//    public String gerarTokenEmail(Usuario usuario){
//        return Jwts.builder()
//                .setSubject(usuario.getEmail())
//                .setIssuedAt(new Date())
//                .setExpiration(dataExpiracao())
//                .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                .compact();
//    }


    // método que irá verificar se o token esta valido e irá retornar o usuario do
    // subject que esta
    // amarzenado no token
    public String getSubject(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("API tractor_muscle")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }

//    private Instant dataExpiracao(){
//        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
//    }

//    private Instant dataEmailExpiracao(){
//        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
//    }
}
