package com.fxvfx.spring_boot.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fxvfx.spring_boot.api.model.Friend;

public interface FriendRepository extends JpaRepository<Friend, Integer> {
    
}
