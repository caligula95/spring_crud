package com.javamaster.spring_crud.repository;

import com.javamaster.spring_crud.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByLogin(String login);
}
