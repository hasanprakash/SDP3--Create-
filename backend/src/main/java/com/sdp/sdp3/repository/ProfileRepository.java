package com.sdp.sdp3.repository;

import java.util.List;

import com.sdp.sdp3.entities.Profile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    public List<Profile> findByUsername(String username);
}
