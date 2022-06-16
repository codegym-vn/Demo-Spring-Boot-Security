package com.example.democ0222i1sercurity.repo;

import com.example.democ0222i1sercurity.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByName(String name);
}
