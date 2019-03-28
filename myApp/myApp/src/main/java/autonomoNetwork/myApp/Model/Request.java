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
    @JoinColumn(nullable = false,name = "username")
    @NotNull
    @ManyToOne(cascade = CascadeType.DETACH)
    private Customer customer;
    @JoinColumn(nullable = false)
    @NotNull
    @ManyToOne(cascade = CascadeType.DETACH)
    private Service serviceRequested;
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

    public Request(@NotNull String serviceDate, @NotNull String requestDate, @NotNull String adress, @NotNull double benefit, @NotNull String state, @NotNull String description) {
        this.serviceDate = serviceDate;
        this.requestDate = requestDate;
        this.adress = adress;
        this.benefit = benefit;
        this.state = state;
        this.description = description;
    }

    public Request(){

    }

    public void addUser (Customer customer){
        customer.addRequest(this);
        this.customer=customer;
    }

    public void addService (Service service){
        this.serviceRequested=service;
    }


}
