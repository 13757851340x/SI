package autonomoNetwork.myApp.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Professional extends User {
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "professional_service", joinColumns = @JoinColumn(name = "professionals"), inverseJoinColumns = @JoinColumn(name = "services"))
    private List<Service> services;
    private int frequency;
    public Professional (){

    }

    public Professional(String username, @NotNull String password, @NotNull String name, @NotNull String surname, @NotNull String profile, @NotNull String birthday, @NotNull String city,int frequency) {
        super(username,password,name,surname,profile,birthday,city);
        this.frequency=frequency;
    }

    public void addService (Service service){
        if (this.services==null){
            this.services= new ArrayList<>();
        }
        this.services.add(service);
    }

    public void removeService (Service service){
        this.services.remove(service);
    }

    public int getFrequency(){
        return this.frequency;
    }

    public void setFrequency(int frequency){
        this.frequency=frequency;
    }
}
