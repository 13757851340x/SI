package autonomoNetwork.myApp.Model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Analyst extends User {
    public Analyst(){

    }

    public Analyst(String username, @NotNull String password, @NotNull String name, @NotNull String surname, @NotNull String profile, @NotNull String birthday, @NotNull String city) {
        super(username,password,name,surname,profile,birthday,city);
    }
}
