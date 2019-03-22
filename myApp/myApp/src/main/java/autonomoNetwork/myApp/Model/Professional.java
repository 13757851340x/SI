package autonomoNetwork.myApp.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Professional extends User {
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Service> services;

    public Professional (){

    }

    public Professional(String username, @NotNull String password, @NotNull String name, @NotNull String surname, @NotNull String profile, @NotNull String birthday, @NotNull String city) {
        super(username,password,name,surname,profile,birthday,city);
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
}
