package com.kata_academy.pp_3_1_2_crud_app_spring_boot.repository;

import com.kata_academy.pp_3_1_2_crud_app_spring_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
