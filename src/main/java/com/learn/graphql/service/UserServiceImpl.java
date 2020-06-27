package com.learn.graphql.service;

import com.google.common.base.Preconditions;
import com.learn.graphql.model.User;
import com.learn.graphql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getById(Integer id) {
        if(id == null) {
            throw new RuntimeException("id can't be null");
        }
        return repository.get(id);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public void save(User user) {
        if(user == null) {
            throw new RuntimeException("user entity can't be null");
        }
        repository.save(user);
    }
}
