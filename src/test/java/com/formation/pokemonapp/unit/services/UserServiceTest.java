package com.formation.pokemonapp.unit.services;

import com.formation.pokemonapp.entity.User;
import com.formation.pokemonapp.enumeration.Role;
import com.formation.pokemonapp.exception.model.EmailExistException;
import com.formation.pokemonapp.exception.model.UserNameExistException;
import com.formation.pokemonapp.exception.model.UserNotFoundException;
import com.formation.pokemonapp.repository.UserRepository;
import com.formation.pokemonapp.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.mail.MessagingException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@DataJpaTest
@DisplayName("User service should")
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private UserServiceImpl userService;
    private User user;

    @Captor
    ArgumentCaptor<User> userCaptor;

    @BeforeEach
    void setUp() {
        getMockHttpServletRequest();
        userService = new UserServiceImpl(userRepository, passwordEncoder);
    }

    private void getMockHttpServletRequest() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    @DisplayName("register user succesfully")
    void registerUserSuccesfully() throws UserNotFoundException, EmailExistException, MessagingException, UserNameExistException {
        userService.register("Jackie", "Chan", "LeCrack", "jackiechan@hotmail.com");
        verify(userRepository, times(1)).save(userCaptor.capture());
        assertThat(userCaptor.getValue().getFirstName()).isEqualTo("Jackie");
        assertThat(userCaptor.getValue().getLastName()).isEqualTo("Chan");
        assertThat(userCaptor.getValue().getUsername()).isEqualTo("LeCrack");
        assertThat(userCaptor.getValue().getEmail()).isEqualTo("jackiechan@hotmail.com");
    }

    @Test
    @DisplayName("add new user succesfully")
    void addNewUserSuccesfully() throws UserNotFoundException, EmailExistException, UserNameExistException, IOException {
        userService.addNewUser("Zidane", "Zinedine", "MeilleurJoueur",
                "zz@caramail.fr", Role.ROLE_ADMIN.toString(), true, true, null);
        verify(userRepository, times(1)).save(userCaptor.capture());
        assertThat(userCaptor.getValue().getFirstName()).isEqualTo("Zidane");
        assertThat(userCaptor.getValue().getLastName()).isEqualTo("Zinedine");
        assertThat(userCaptor.getValue().getUsername()).isEqualTo("MeilleurJoueur");
        assertThat(userCaptor.getValue().getEmail()).isEqualTo("zz@caramail.fr");
        assertThat(userCaptor.getValue().getRole()).isEqualTo(Role.ROLE_ADMIN.toString());
        assertThat(userCaptor.getValue().isNotLocked()).isEqualTo(true);
        assertThat(userCaptor.getValue().isActive()).isEqualTo(true);
        assertThat(userCaptor.getValue().getProfileImageUrl()).isNotEmpty();
    }
}
