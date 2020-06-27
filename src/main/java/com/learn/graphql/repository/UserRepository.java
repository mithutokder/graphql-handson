package com.learn.graphql.repository;

import com.learn.graphql.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public User get(Integer id) {
        return users.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(new User());
    }

    public List<User> getAll() {
        return users;
    }

    public void save(User user) {
        users.add(user);
    }
}
