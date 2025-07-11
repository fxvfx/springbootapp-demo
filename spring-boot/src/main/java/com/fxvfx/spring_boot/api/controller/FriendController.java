package com.fxvfx.spring_boot.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fxvfx.spring_boot.api.model.Friend;
import com.fxvfx.spring_boot.service.FriendService;

@RestController
@RequestMapping("api/v1/friends")
public class FriendController {

    private final FriendService friendService;

    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }
    
    @GetMapping()
    public List<Friend> getFriends() {
        return friendService.getAllFriends();
    }

    @PostMapping
    public void addNewFriend(@RequestBody Friend aFriend) {
        friendService.insertFriend(aFriend);
    }

    @GetMapping("{id}")
    public Friend getFriendById(@PathVariable Integer id) {
        return friendService.getFriendById(id);
    }

    @DeleteMapping("{id}")
    public void delFriendById(@PathVariable Integer id) {
        friendService.delFriendById(id);
    }

    @PutMapping("{id}")
    public Friend updateFriendByid(@RequestBody Friend aFriend, @PathVariable Integer id) {
        return friendService.updateFriendById(aFriend, id);
    }
}


