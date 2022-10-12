package com.example.foodplannerproject.service;


import com.example.foodplannerproject.domain.Admin;
import com.example.foodplannerproject.domain.User;
import com.example.foodplannerproject.repository.AdminRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin save(Admin admin){
        adminRepository.save(admin);
        return admin;
    }
}
