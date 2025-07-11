package com.fxvfx.spring_boot.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fxvfx.spring_boot.api.model.Friend;

@RestController
@RequestMapping("api/v1/friends")
public class FriendController {
    
    @GetMapping()
    public List<Friend> getFriends() {
        return List.of(
            new Friend(
                1,
                "Theo",
                1,
                false
            ),
            new Friend(
                2,
                "Eric",
                2,
                false
            ),
            new Friend(
                3,
                "David",
                0,
                false
            ),
            new Friend(
                4,
                "Heather",
                0,
                false
            ),
            new Friend(
                5,
                "Cas",
                0,
                false
            )
        );
    }
}
