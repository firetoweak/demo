package com.example.demo.domain.dao;

import com.example.demo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String userName);
    User FindByNameOrEmail(String userName,String email);

}
