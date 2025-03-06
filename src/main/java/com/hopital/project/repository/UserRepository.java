package com.hopital.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hopital.project.tables.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

