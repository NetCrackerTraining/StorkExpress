package services;

import crud.UserController;
import services.model.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Влад on 06.12.2016.
 */
@WebService
public class GetAllUsers {
    @WebMethod
    public String getTestString(){
        return "test string";
    }


    @WebMethod
    public String sayHelloTo(@WebParam(name = "text") String text) {
        return "Hello to " + text;
    }


    @WebMethod
    public @WebResult(name="user")User getTestUser(){
        User user = new User();
        user.setEmail("email@email.ru");
        user.setPassword("1111");
        user.setUsername("username");

        return user;
    }

    @WebMethod
    public @WebResult(name="user")List<User> getUsers(){
        UserController userController = new UserController();
        List<entity.User> usersFromDB = userController.getAllUsers();
        List<User> users = new ArrayList<>();
        for(entity.User entityUser: usersFromDB){
            User user = new User(entityUser.getUsername(),
                    entityUser.getPassword(),
                    entityUser.getEmail());
            users.add(user);
        }
        return users;
    }
}
