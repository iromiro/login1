package com.example.login1.repository;

import com.example.login1.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);
}
