package com.example.hieu.repository;

import com.example.hieu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findAllByUserName(String name);
}
