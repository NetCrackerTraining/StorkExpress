package services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

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
}
