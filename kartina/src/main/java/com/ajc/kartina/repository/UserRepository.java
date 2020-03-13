package com.ajc.kartina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajc.kartina.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
