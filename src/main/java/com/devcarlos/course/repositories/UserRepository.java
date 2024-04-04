package com.devcarlos.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcarlos.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
