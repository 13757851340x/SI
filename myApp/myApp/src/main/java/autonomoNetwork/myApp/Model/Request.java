package autonomoNetwork.myApp.Model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Entity
@Data
public class Request {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Service service;
    @JoinColumn(nullable = false,name = "username")
    @NotNull
    @ManyToOne
    private User user;
    @Column(nullable = false)
    @NotNull
    private String serviceRequested;
    @Column(nullable = false)
    @NotNull
    private String serviceDate;
    @Column(nullable = false)
    @NotNull
    private String requestDate;
    @Column(nullable = false)
    @NotNull
    private String adress;
    @Column(nullable = false)
    @NotNull
    private double benefit;
    @Column(nullable = false)
    @NotNull
    private String state;
    @Column(nullable = false)
    @NotNull
    private String description;

    public Request(@NotNull Service service, @NotNull User user, @NotNull String serviceRequested, @NotNull String serviceDate, @NotNull String requestDate, @NotNull String adress, @NotNull double benefit, @NotNull String state, @NotNull String description) {
        this.service = service;
        this.user = user;
        this.serviceRequested = serviceRequested;
        this.serviceDate = serviceDate;
        this.requestDate = requestDate;
        this.adress = adress;
        this.benefit = benefit;
        this.state = state;
        this.description = description;
    }

    public Request(){

    }

    public void addUser (User user){
        this.user=user;
    }


}
