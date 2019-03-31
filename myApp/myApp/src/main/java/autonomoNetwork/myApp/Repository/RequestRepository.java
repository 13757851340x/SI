package autonomoNetwork.myApp.Repository;

import autonomoNetwork.myApp.Model.Request;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request,Long> {
    long countByProfessional(String username);


}
