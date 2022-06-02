package com.formation.pokemonapp.unit.repositories;

import com.formation.pokemonapp.entity.User;
import com.formation.pokemonapp.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayName("User repository should")
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("get no existing user")
    void getUser() {
        List<User> users = userRepository.findAll();
        assertThat(users).isEmpty();
    }

    @Test
    @DisplayName("save user successfully")
    void saveUser() {
        User user = User.builder()
                .id(1L)
                .userId("userOne")
                .firstName("Johnny")
                .lastName("Depp")
                .username("Cpt Jack Sparrow")
                .email("jack_sparrow@gmail.com")
                .profileImageUrl("JROEZJ2A30")
                .lastLoginDate(new Date())
                .lastLoginDateDisplay(new Date())
                .joinDate(new Date())
                .role("ADMIN")
                .authorities(new String[2])
                .isActive(true)
                .isNotLocked(true)
                .build();

        userRepository.save(user);
        assertThat(userRepository.findAll()).hasSize(1);
    }

    @Test
    @DisplayName("save multiple user successfully")
    void saveMultipleUser() {
        User userOne = User.builder()
                .id(2L)
                .userId("userTwo")
                .firstName("Amber")
                .lastName("Turd")
                .username("worstActor")
                .email("amber_turd@gmail.com")
                .profileImageUrl("JROEZJ2A31")
                .lastLoginDate(new Date())
                .lastLoginDateDisplay(new Date())
                .joinDate(new Date())
                .role("USER")
                .authorities(new String[2])
                .isActive(true)
                .isNotLocked(true)
                .build();

        User userTwo = User.builder()
                .id(3L)
                .userId("userThree")
                .firstName("sfes")
                .lastName("esfes")
                .username("fsefes")
                .email("fqdsfqs@gmail.com")
                .profileImageUrl("JROEZJ2A32")
                .lastLoginDate(new Date())
                .lastLoginDateDisplay(new Date())
                .joinDate(new Date())
                .role("USER")
                .authorities(new String[2])
                .isActive(true)
                .isNotLocked(true)
                .build();

        userRepository.saveAll(List.of(userOne, userTwo));
        assertThat(userRepository.findAll()).hasSize(2);
    }
}
