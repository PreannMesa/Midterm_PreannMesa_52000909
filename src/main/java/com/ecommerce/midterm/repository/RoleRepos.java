package com.ecommerce.midterm.repository;

import com.ecommerce.midterm.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepos extends JpaRepository<Role, Integer> {
}
