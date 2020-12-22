package repository;

import model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vladimir Mann
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
