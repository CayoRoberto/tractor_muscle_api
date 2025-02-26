package com.example.tractor_muscle_api.repository;

import com.example.tractor_muscle_api.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    UserDetails findByLogin(String username);

    boolean existsByLogin(String login);


    @Query("""
            select u from Usuario u
            where
            u.login = :login
            """)
    Usuario findUsuarioByLogin(String login);


    @Query("""
            select u.id from Usuario u
            where
            u.login =:login
            """)
    Long findIdforLogin(String login);


    @Query("""
            select u from Usuario u
            where
            u.login = :email
            """)
    Usuario findUsuarioByEmail(String email);


}
