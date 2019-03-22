package autonomoNetwork.myApp.Model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @Column(length = 64)
    private String username;
    @Column(nullable = false)
    @NotNull
    private String password;
    @Column(nullable = false)
    @NotNull
    private String name;
    @Column(nullable = false)
    @NotNull
    private String surname;
    @Column(nullable = false)
    @NotNull
    private String profile;
    @Column(nullable = false)
    @NotNull
    private String birthday;
    @Column(nullable = false)
    @NotNull
    private String city;

    public User(String username, @NotNull String password, @NotNull String name, @NotNull String surname, @NotNull String profile, @NotNull String birthday, @NotNull String city) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.profile = profile;
        this.birthday = birthday;
        this.city = city;
    }

    public User(){

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return profile;
    }
}
