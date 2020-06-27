package com.learn.graphql.model;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class UserInput {

    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNo;
}
