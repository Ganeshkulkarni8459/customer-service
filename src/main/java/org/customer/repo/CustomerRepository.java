package org.customer.repo;

import java.util.List;
import org.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  List<Customer> findByEmailId(String mobilePhone);
}
