package com.learn.graphql;

import com.learn.graphql.model.Role;
import com.learn.graphql.model.User;
import com.learn.graphql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String ...args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {

        for(int i=0; i<100; i++) {
            final Role role = new Role();
            role.setName("role"+i);
            final User user = new User();
            user.setId(i);
            user.setFirstName("f name"+i);
            user.setLastName("l name"+i);
            user.setPhoneNo("9874"+i);
            user.getRoles().add(role);
            repository.save(user);
        }
        System.out.println("Populated dummy data");
    }
}
