package autonomoNetwork.myApp.Repository;

import autonomoNetwork.myApp.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
