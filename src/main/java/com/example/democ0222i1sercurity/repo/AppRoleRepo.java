package com.example.democ0222i1sercurity.repo;

import com.example.democ0222i1sercurity.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepo extends JpaRepository<AppRole, Long> {
}
