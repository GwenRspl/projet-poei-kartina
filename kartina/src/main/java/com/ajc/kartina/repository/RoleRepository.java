package com.ajc.kartina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajc.kartina.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
