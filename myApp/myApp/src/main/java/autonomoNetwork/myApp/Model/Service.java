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
    private String serviceName;
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
    @Column(nullable = false)
    @ElementCollection
    private List<String> citys;
    private int frequency;
    public double totalBenefit;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "professional_service", joinColumns = @JoinColumn(name = "services"), inverseJoinColumns = @JoinColumn(name = "professionals"))
    private List<Professional> professionals;

    @OneToMany(mappedBy = "serviceRequested", cascade = CascadeType.ALL)
    private List<Request> requests;

    public Service(@NotNull String serviceName, @NotNull String description, @NotNull String category, @NotNull int estimateTime, @NotNull double cost,int frequency,int totalBenefit) {
        this.serviceName = serviceName;
        this.description = description;
        this.category = category;
        this.estimateTime = estimateTime;
        this.cost = cost;
        this.frequency=frequency;
        this.totalBenefit=totalBenefit;
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

    public void removeRequest(Request request){
        this.requests.remove(request);
    }

    public List<Professional> getProfessionals(){
        return this.professionals;
    }

    public void addCity(String city){
        if(this.citys==null){
            this.citys=new ArrayList<>();
        }
        this.citys.add(city);
    }

    public int getFrequency(){
        return this.frequency;
    }

    public void setFrequency(int frequency){
        this.frequency=frequency;
    }

    public double getTotalBenefit() {
        return totalBenefit;
    }

    public void setTotalBenefit(double totalBenefit) {
        this.totalBenefit = totalBenefit;
    }

    public double getCost() {
        return cost;
    }
}
