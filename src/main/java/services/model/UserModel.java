package services.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created by Влад on 07.12.2016.
 */
@XmlRootElement(name="usermodel")
@XmlType(propOrder = {"username", "password", "email"})
public class UserModel implements Serializable{
    private String username;
    private String password;
    private String email;


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    @XmlElement(name = "username")
    public void setUsername(String username) {
        this.username = username;
    }
    @XmlElement(name = "password")
    public void setPassword(String password) {
        this.password = password;
    }
    @XmlElement(name = "email")
    public void setEmail(String email) {
        this.email = email;
    }
}
