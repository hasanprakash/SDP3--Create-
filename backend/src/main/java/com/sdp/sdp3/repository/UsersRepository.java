package com.sdp.sdp3.repository;

import java.util.List;

import com.sdp.sdp3.entities.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    public List<Users> findByUsername(String username);

    public List<Users> findByEmail(String email);
}
