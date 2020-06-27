package com.learn.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.learn.graphql.model.UserInput;
import com.learn.graphql.model.User;
import com.learn.graphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is responsible for GraphQL Query operation implementation. Refer to the {@code graphql/userql.graphqls} file.
 */
@Component
public class UserQueryResolver implements GraphQLQueryResolver {

    private final UserService userService;

    @Autowired
    public UserQueryResolver(UserService userRepository) {
        this.userService = userRepository;
    }

    public List<User> users(UserInput param) {
        System.out.println(param);
        return userService.getAll().stream().filter(e -> {
            if(param == null) {
                return true;
            }
            boolean idMatch = false;
            if(param.getId() != null) {
                idMatch = e.getId().equals(param.getId());
            }

            boolean fMatch = false;
            if(param.getFirstName() != null) {
                fMatch = e.getFirstName().equals(param.getFirstName());
            }

            boolean lMatch = false;
            if(param.getLastName() != null) {
                lMatch = e.getLastName().equals(param.getLastName());
            }

            boolean pMatch = false;
            if(param.getPhoneNo() != null) {
                pMatch = e.getPhoneNo().equals(param.getPhoneNo());
            }

            return idMatch || fMatch || lMatch || pMatch;
        }).collect(Collectors.toList());
    }
}
