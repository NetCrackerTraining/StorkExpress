package entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Влад on 08.11.2016.
 */
@Entity
@Table(name = "users")
public class User extends AbstractEntity {
    @Column(name = "firstName", length = 30)
    private String firstName;
    @Column(name = "lastName", length = 30)
    private String lastName;
    @Column(name = "phoneNumber", length = 20)
    private String phoneNumber;
    @Column(name="email", nullable = false, length = 50)
    private String email;
    @Column(name = "username", nullable = false, length = 30)
    private String username;
    @Column(name = "password", nullable = false, length = 30)
    private String password;
    @Column(name = "role", nullable = false)
    private int role;

    public User() {
        this.setRole(1);
    }

    public User(String username, String password, String email) {
        this.password = password;
        this.username = username;
        this.email = email;
        this.setRole(1);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
