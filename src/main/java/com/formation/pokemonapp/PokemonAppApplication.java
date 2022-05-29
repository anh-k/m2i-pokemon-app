package com.formation.pokemonapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.File;

import static com.formation.pokemonapp.constant.FileConstant.USER_FOLDER;

@SpringBootApplication
public class PokemonAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(PokemonAppApplication.class, args);
        new File(USER_FOLDER).mkdirs();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder (){
        return new BCryptPasswordEncoder();
    }

}
