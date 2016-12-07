package services.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Влад on 07.12.2016.
 */
@XmlRootElement(name="user")
public class User {
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
