package com.devcarlos.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcarlos.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
