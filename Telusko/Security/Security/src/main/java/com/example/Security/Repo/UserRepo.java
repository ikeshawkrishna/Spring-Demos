package com.example.Security.Repo;

import com.example.Security.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, String> {
    Users findByUsername(String username);
}
