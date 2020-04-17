package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.UsersDto;
import com.javamaster.spring_crud.exception.ValidationException;
import com.javamaster.spring_crud.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.javamaster.spring_crud.prototype.UsersPrototype.aUser;
import static com.javamaster.spring_crud.prototype.UsersPrototype.aUserDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DefaultUsersServiceTest {

    private UsersRepository usersRepository;
    private UsersConverter usersConverter;
    private UsersService usersService;

    @BeforeEach
    void setUp() {
        usersRepository = mock(UsersRepository.class);
        usersConverter = new UsersConverter();
        usersService = new DefaultUsersService(usersRepository, usersConverter);
    }

    @Test
    void saveUser() throws ValidationException {
        when(usersRepository.save(any())).thenReturn(aUser());
        UsersDto createdUser = usersService.saveUser(aUserDTO());
        assertThat(createdUser).isNotNull();
        assertThat(createdUser.getName()).isEqualTo(aUserDTO().getName());
    }

    @Test
    void saveUserThrowsValidationExceptionWhenLoginIsNull() {
        UsersDto usersDto = aUserDTO();
        usersDto.setLogin("");
        assertThrows(ValidationException.class,
                () -> usersService.saveUser(usersDto),
                "Login is empty");
    }

    @Test
    void deleteUser() {
    }

    @Test
    void findByLogin() {
        when(usersRepository.findByLogin(eq("test_login"))).thenReturn(aUser());
        UsersDto foundUser = usersService.findByLogin("test_login");
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getLogin()).isEqualTo("test_login");
    }

    @Test
    void findAll() {
    }
}
