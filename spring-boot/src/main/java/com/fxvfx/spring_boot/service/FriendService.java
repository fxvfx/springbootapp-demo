package com.fxvfx.spring_boot.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fxvfx.spring_boot.api.model.Friend;
import com.fxvfx.spring_boot.service.impl.FriendRepository;

@Service
public class FriendService {
    private final FriendRepository friendRepository;

    public FriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    public List<Friend> getAllFriends() {
        return friendRepository.findAll();
    }

    public void insertFriend(Friend aFriend) {
        friendRepository.save(aFriend);
    }

    public Friend getFriendById(Integer id) {
        return friendRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Friend with id " + id + " not found.")
            );
    }

    public void delFriendById(Integer id) {
        friendRepository.deleteById(id);
    }

    public Friend updateFriendById(Friend aFriend, Integer id) {
        Friend toUpdate = friendRepository.findById(id).get();
        
        toUpdate.setId(aFriend.getId());
        toUpdate.setName(aFriend.getName());
        toUpdate.setNumCats(aFriend.getNumCats());
        toUpdate.setCanEatHeadOfLettuce(aFriend.isCanEatHeadOfLettuce());

        return friendRepository.save(toUpdate);
    }

}
