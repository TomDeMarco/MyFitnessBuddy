package com.myfitnessbuddy.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myfitnessbuddy.app.entity.User;

// gets user objects and Long for ID
// removes the need to write raw SQL queries to CRUD ops
public interface UserRepository extends JpaRepository<User, Long>{
    // JpaRepository provides basic CRUD ops but we may have to custom write some in the future
}
