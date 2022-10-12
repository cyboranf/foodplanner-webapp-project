package com.example.foodplannerproject.repository;


import com.example.foodplannerproject.domain.Admin;
import com.example.foodplannerproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin save(Admin admin);

    Optional<Admin> findAllByEmail(String email);

    Optional<Admin> findAllById(Long id);
}
