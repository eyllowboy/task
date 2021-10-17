package com.example.tasl004.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tasl004.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
