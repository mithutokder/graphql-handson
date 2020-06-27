package com.learn.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.learn.graphql.model.Role;
import com.learn.graphql.model.User;
import com.learn.graphql.model.UserInput;
import com.learn.graphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This class responsible for handling the GraphQL Mutation implementation. Refer to the {@code graphql/userql.graphqls} file.
 */
@Component
public class UserMutationResolver implements GraphQLMutationResolver {

    private final UserService userService;

    @Autowired
    public UserMutationResolver(UserService userService) {
        this.userService = userService;
    }

    /**
     * This method creates the user with the provided user input.
     * @param param
     * @return
     */
    public User createUser(UserInput param) {
        User user = new User();
        user.setId(param.getId());
        user.setFirstName(param.getFirstName());
        user.setLastName(param.getLastName());
        user.setPhoneNo(param.getPhoneNo());
        userService.save(user);
        return user;
    }

    /**
     * This method add role to the {@code User} with the provided Id parameter.
     * @param id
     * @param role
     * @return
     */
    public User addRole(Integer id, String role) {
        final User user = userService.getById(id);
        if(user != null) {
            user.getRoles().add(new Role(role));
            return user;
        } else {
            return new User();
        }
    }
}
