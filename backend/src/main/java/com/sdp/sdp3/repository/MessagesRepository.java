package com.sdp.sdp3.repository;

import com.sdp.sdp3.entities.Messages;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagesRepository  extends JpaRepository<Messages, Integer> {
    
}
