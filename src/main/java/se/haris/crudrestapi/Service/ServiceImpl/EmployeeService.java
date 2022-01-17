package se.haris.crudrestapi.Service.ServiceImpl;

import org.springframework.stereotype.Service;
import se.haris.crudrestapi.Model.Employee;

import java.util.List;

@Service
public interface EmployeeService {


    Employee save (Employee employee);
    List<Employee> findAll( );
    Employee getById(Long id);
    Employee update(Employee employee,Long id);
    void delete(Long id);
}



