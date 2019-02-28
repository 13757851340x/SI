package autonomoNetwork.myApp.Model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class User {
    @Id
    @GeneratedValue
    private String username;
    @Column(nullable = false)
    @NotNull
    private String name;
    @Column(nullable = false)
    @NotNull
    private String surname;
    @Column(nullable = false)
    @NotNull
    private String password;
    @Column(nullable = false)
    @NotNull
    private String profile;
    @Column(nullable = false)
    @NotNull
    private String date;
    @Column(nullable = false)
    @NotNull
    private String city;

    private Set<String> roles;

    public void addRole(String role) {
        if (this.roles == null) {
            this.roles = new HashSet<>();
        }
        this.roles.add(role);
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
