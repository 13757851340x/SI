package autonomoNetwork.myApp.Repository;

import autonomoNetwork.myApp.Model.Analyst;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalystRepository extends JpaRepository<Analyst,String> {
}
