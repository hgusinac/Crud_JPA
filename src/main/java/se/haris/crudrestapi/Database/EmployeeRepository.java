package se.haris.crudrestapi.Database;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import se.haris.crudrestapi.Model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
