package com.fxvfx.spring_boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fxvfx.spring_boot.api.exception.FriendNotFoundException;
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

    public Friend insertFriend(Friend aFriend) {
        return friendRepository.save(aFriend);
    }

    public List<Friend> insertFriends(Friend[] friends) {
        List<Friend> friendList = new ArrayList<>();
        for (Friend aFriend : friends) {
            friendRepository.save(aFriend);
            friendList.add(aFriend);
        }
        return friendList;
    }

    public Friend getFriendById(Integer id) {
        // return friendRepository.findById(id).orElseThrow(
        //     () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Friend with id " + id + " not found.")
        //     );
        return friendRepository.findById(id).orElseThrow(
            () -> new FriendNotFoundException(id));
    }

    public Friend delFriendById(Integer id) {
        Friend delFriend = getFriendById(id);
        friendRepository.deleteById(id);
        return delFriend;
    }

    public Friend updateFriendById(Friend aFriend, Integer id) {
        // Friend toUpdate = friendRepository.findById(id).get();
        Friend toUpdate = getFriendById(id);
        
        toUpdate.setId(aFriend.getId());
        toUpdate.setName(aFriend.getName());
        toUpdate.setNumCats(aFriend.getNumCats());
        toUpdate.setCanEatHeadOfLettuce(aFriend.isCanEatHeadOfLettuce());

        return friendRepository.save(toUpdate);
    }

}
