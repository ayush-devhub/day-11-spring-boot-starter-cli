package dev.ayush.springBootStarterCli.service;

import dev.ayush.springBootStarterCli.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserService {
    private final Map<Integer, User> users = new HashMap<>();

    public User register(int id, String email){
        if (users.containsKey(id)) throw new IllegalArgumentException("User with id already exists.");

        User user = new User(id, email);
        users.put(id, user);
        return user;
    }

    public List<User> listUsers(){
        return new ArrayList<>(users.values());
    }

    public boolean deleteUser(int id){
        return users.remove(id) != null;
    }

}
