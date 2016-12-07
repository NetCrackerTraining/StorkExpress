package services;

import crud.UserController;
import services.model.UserModel;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Влад on 06.12.2016.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
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
    public @WebResult(name="usermodel")UserModel getTestUser(){
        UserModel user = new UserModel();
        user.setEmail("email@email.ru");
        user.setPassword("1111");
        user.setUsername("username");

        return user;
    }

    @WebMethod
    public @WebResult(name="usermodel")UserModel[] getUsers(){
        UserController userController = new UserController();
        List<entity.User> usersFromDB = userController.getAllUsers();
        UserModel users[] = new UserModel[usersFromDB.size()];
        int t = 0;
        for(entity.User entityUser: usersFromDB){
            UserModel user = new UserModel();
            user.setUsername(entityUser.getUsername());
            user.setPassword(entityUser.getPassword());
            user.setEmail(entityUser.getEmail());
            users[t] = user;
            t++;
        }
        return users;
    }
}
