package se.haris.crudrestapi.Service.ServiceImpl;

import lombok.Data;
import org.springframework.stereotype.Service;
import se.haris.crudrestapi.Database.EmployeeRepository;
import se.haris.crudrestapi.Exeptions.ResourceNotFoundExecption;
import se.haris.crudrestapi.Model.Employee;

import java.util.List;

@Service
@Data
public class EmployeeServiceImpl implements EmployeeService{


    private final  EmployeeRepository employeeRepository;


    public Employee save (Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
       return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Long id) {
       return employeeRepository.findById(id).orElseThrow(()->
               new ResourceNotFoundExecption("Employee","id",id));
    }

    @Override
    public Employee update(Employee employee, Long id) {
        Employee exitingEmployee = employeeRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundExecption("Employee","id",id)
        ) ;
        exitingEmployee.setFirstName(employee.getFirstName());
        exitingEmployee.setLastName(employee.getLastName());
        exitingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(exitingEmployee);

        return exitingEmployee;
    }

    @Override
    public void delete(Long id) {
       employeeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("id was null"));
       employeeRepository.deleteById(id);
    }
}
