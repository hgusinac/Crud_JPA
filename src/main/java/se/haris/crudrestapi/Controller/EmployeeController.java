package se.haris.crudrestapi.Controller;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.haris.crudrestapi.Model.Employee;
import se.haris.crudrestapi.Service.ServiceImpl.EmployeeService;

import java.util.List;

@RestController
@Data
@RequestMapping("http://localhost:8080/api/employees")
public class EmployeeController {

    private  EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //create
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee){

        return new ResponseEntity<Employee>(employeeService.save(employee),HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> getAll( ){
        return employeeService.findAll();
    }


    @GetMapping("{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") long id){
        return new ResponseEntity<Employee>(employeeService.getById(id), HttpStatus.OK);

    }
    @PutMapping("{id}")
    public ResponseEntity<Employee> update(@RequestBody Employee employee,@PathVariable("id") Long id){
        return new ResponseEntity<Employee>(employeeService.update(employee,id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        employeeService.delete(id);
        return new ResponseEntity<String>("Employee deleted successfully",HttpStatus.OK);
    }

}
