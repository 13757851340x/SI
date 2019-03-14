package autonomoNetwork.myApp.Model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Service {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    @NotNull
    private String name;
    @Column(nullable = false)
    @NotNull
    private String description;
    @Column(nullable = false)
    @NotNull
    private String category;
    @Column(nullable = false)
    @NotNull
    private int estimateTime;
    @Column(nullable = false)
    @NotNull
    private double cost;
    @OneToMany
    @ElementCollection
    private List<User> user;

    public Service(@NotNull String name, @NotNull String description, @NotNull String category, @NotNull int estimateTime, @NotNull double cost, List<User> user) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.estimateTime = estimateTime;
        this.cost = cost;
        this.user = user;
    }

    public Service(){

    }

    public void addUser(User user){
        if(this.user==null){
            this.user= new ArrayList<>();
        }
        this.user.add(user);
    }
    public void removeUser (User user){
        this.user.remove(user);
    }
}
