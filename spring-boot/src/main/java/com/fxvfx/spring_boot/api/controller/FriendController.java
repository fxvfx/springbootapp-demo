package com.fxvfx.spring_boot.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Friend>> getFriends() {
        return ResponseEntity.ok(friendService.getAllFriends());
    }

    @PostMapping
    public ResponseEntity<List<Friend>> addNewFriends(@RequestBody Friend[] friends) {
        return new ResponseEntity<>(friendService.insertFriends(friends), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Friend> getFriendById(@PathVariable Integer id) {
        return ResponseEntity.ok(friendService.getFriendById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delFriendById(@PathVariable Integer id) {
        Friend delFriend = friendService.delFriendById(id);
        return ResponseEntity.ok("Friend \"" + delFriend.getName() + "\" deleted successfully."); // can also send 204 w/ no body
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateFriendByid(@RequestBody Friend aFriend, @PathVariable Integer id) {
        friendService.updateFriendById(aFriend, id);
        return ResponseEntity.noContent().build();
    }
}



