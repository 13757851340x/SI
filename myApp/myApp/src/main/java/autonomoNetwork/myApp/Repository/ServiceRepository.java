package autonomoNetwork.myApp.Repository;

import autonomoNetwork.myApp.Model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Long> {
}
