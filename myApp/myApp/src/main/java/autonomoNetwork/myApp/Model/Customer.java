package autonomoNetwork.myApp.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends  User {
    @OneToMany(cascade = CascadeType.ALL)
    private List<Request> requests;

    public Customer(){

    }
    public Customer(String username, @NotNull String password, @NotNull String name, @NotNull String surname, @NotNull String profile, @NotNull String birthday, @NotNull String city) {
        super(username,password,name,surname,profile,birthday,city);
    }

    public void addRequest (Request request){
        if(this.requests==null){
            this.requests=new ArrayList<>();
        }
        this.requests.add(request);
    }

    public void removeRequest(Request request){
        this.requests.remove(request);
    }
}
