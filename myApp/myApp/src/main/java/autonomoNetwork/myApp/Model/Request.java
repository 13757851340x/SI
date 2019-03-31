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
    @JoinColumn(nullable = false)
    @NotNull
    @ManyToOne(cascade = CascadeType.DETACH)
    private Customer customer;
    private String professional;
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
    private boolean state;
    @Column(nullable = false)
    @NotNull
    private String description;

    public Request(@NotNull String serviceDate, @NotNull String requestDate, @NotNull String adress, @NotNull double benefit, @NotNull boolean state, @NotNull String description) {
        this.serviceDate = serviceDate;
        this.requestDate = requestDate;
        this.adress = adress;
        this.benefit = benefit;
        this.state = state;
        this.description = description;
    }

    public Request(){

    }

    public void addCustomer(Customer customer){
        customer.addRequest(this);
        this.customer=customer;
    }

    public void addProfessional(String professional){
        this.professional=professional;
    }


    public void addService (Service service){
        this.serviceRequested=service;
    }

    public void setState(){
        this.state=true;
    }

    public Service getServiceRequested(){
        return this.serviceRequested;
    }

    public String getProfessional() {
        return professional;
    }
}
