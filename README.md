# GraphQL
This project contains the simple operations using GraphQL

# Build
To build the application use the below command

```shell script
mvn clean install
```

# Run the application
To run the application use the below command
```shell script
mvn spring-boot:run
```
# Access GraphQL application

Use the below url to access the application
```shell script
localhost:8080/graphiql
```

# GraphQL Operations
## Query
1. Query json to fetch the all the records
```shell script
query {
  users {
    firstName
    phoneNo
    roles {
      name
    }
  }
}
```
1.Query using filters
```shell script
query {
  users(param:{id:101}) {
    firstName
    phoneNo
    roles {
      name
    }
  }
}
```

## Mutations
1.Create new user
```shell script
mutation {
  createUser(param:{id:101, firstName:"Mithu", lastName:"Tokder", phoneNo:"9874833661"}) {
    id
  }
}
```
2.Update User to add role
```shell script
mutation {
  addRole(id:101, role:"Admin") {
    id
  }
}
``` 
