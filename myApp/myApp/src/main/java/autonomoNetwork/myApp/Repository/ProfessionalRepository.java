package autonomoNetwork.myApp.Repository;

import autonomoNetwork.myApp.Model.Professional;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessionalRepository extends JpaRepository<Professional,String> {
    List<Professional> findAllByOrderByFrequency();
}
