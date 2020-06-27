package com.learn.graphql.service;

import com.learn.graphql.model.User;

import java.util.List;

public interface UserService {

    User getById(final Integer id);

    List<User> getAll();

    void save(User user);
}
