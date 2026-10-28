package org.arti.service;

import org.arti.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private Map<Integer, User> userDB;

    public UserService(){
        userDB=new HashMap<>();

    }

    public User createUser(User userReq){
        userDB.put(userReq.getId(), userReq);
        return userReq;
    }


    public User getUserById(Integer id){
        return userDB.getOrDefault(id,null);
    }

    public List<User> getAllUsers(){
        List<User> userRes=new ArrayList<>();
        for(User user: userDB.values()){
            userRes.add(user);
        }
        return userRes;
    }
}
