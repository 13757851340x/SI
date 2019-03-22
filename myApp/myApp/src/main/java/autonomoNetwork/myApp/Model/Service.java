package autonomoNetwork.myApp.Model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


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

    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> user;

    @OneToMany(mappedBy = "serviceRequested", cascade = CascadeType.ALL)
    private List<Request> requests;

    public Service(@NotNull String name, @NotNull String description, @NotNull String category, @NotNull int estimateTime, @NotNull double cost) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.estimateTime = estimateTime;
        this.cost = cost;
    }

    public Service(){

    }

    public void addUser(Professional user){
        if(this.user==null){
            this.user= new ArrayList<>();
        }
        user.addService(this);
        this.user.add(user);
    }
    public void removeUser (User user){
        this.user.remove(user);
    }

    public void addRequest(Request request){
        if(this.requests==null){
            this.requests=new ArrayList<>();
        }
        request.addService(this);
        this.requests.add(request);
    }
}
