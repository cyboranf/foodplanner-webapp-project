package com.example.foodplannerproject.repository;


import com.example.foodplannerproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User save(User user);

    void deleteById(Long id);

    void deleteByEmail(String email);

    Optional<User> findAllById(Long id);
}
