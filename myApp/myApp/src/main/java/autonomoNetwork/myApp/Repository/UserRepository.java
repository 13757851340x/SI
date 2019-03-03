package autonomoNetwork.myApp.Repository;

import autonomoNetwork.myApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

}
