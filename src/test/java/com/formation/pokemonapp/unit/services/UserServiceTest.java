package com.formation.pokemonapp.unit.services;

import com.formation.pokemonapp.entity.User;
import com.formation.pokemonapp.repository.UserRepository;
import com.formation.pokemonapp.service.EmailService;
import com.formation.pokemonapp.service.impl.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@DataJpaTest
@DisplayName("User service should")
public class UserServiceTest {
    private UserServiceImpl userService;
    private User user;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @Mock
    private EmailService emailService;

    @Mock
    private UserRepository userRepository;

    @Captor
    ArgumentCaptor<User> userCaptor;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(userRepository, passwordEncoder, emailService);
        user = User.builder()
                .id(4L)
                .userId("grsdgsd")
                .firstName("dsggrsd")
                .lastName("grdsgsrdg")
                .username("Cpt")
                .email("grsdgsdr@gmail.com")
                .profileImageUrl("JROEZJ2A35")
                .lastLoginDate(new Date())
                .lastLoginDateDisplay(new Date())
                .joinDate(new Date())
                .role("ADMIN")
                .authorities(new String[5])
                .isActive(true)
                .isNotLocked(true)
                .build();
    }

    @Test
    @DisplayName("load by user succesfully")
    void loadByUser() {
        userRepository.save(user);
        Assertions.assertThat(userRepository.findAll()).isNotEmpty();
        var expectedUser = userService.loadUserByUsername("Cpt").getUsername();
        Assertions.assertThat(user.getUsername()).isEqualTo(expectedUser);
    }
}
