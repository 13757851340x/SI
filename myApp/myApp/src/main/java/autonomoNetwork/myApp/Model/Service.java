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

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "professional_service", joinColumns = @JoinColumn(name = "services"), inverseJoinColumns = @JoinColumn(name = "professionals"))
    private List<Professional> professionals;

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

    public void addUser(Professional professional){
        if(this.professionals==null){
            this.professionals= new ArrayList<>();
        }
        professional.addService(this);
        this.professionals.add(professional);
    }
    public void removeUser (User user){
        this.professionals.remove(user);
    }

    public void addRequest(Request request){
        if(this.requests==null){
            this.requests=new ArrayList<>();
        }
        request.addService(this);
        this.requests.add(request);
    }

    public List<Professional> getProfessionals(){
        return this.professionals;
    }
}
