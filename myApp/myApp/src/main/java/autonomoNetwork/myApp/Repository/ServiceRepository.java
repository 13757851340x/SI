package autonomoNetwork.myApp.Repository;

import autonomoNetwork.myApp.Model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service,Long> {

}
