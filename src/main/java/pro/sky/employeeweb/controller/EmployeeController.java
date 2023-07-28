package pro.sky.employeeweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeeweb.dto.Employee;
import pro.sky.employeeweb.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.addEmployee(firstName, lastName);

    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName,@RequestParam String lastName ){
        return employeeService.removeEmployee(firstName,lastName);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String firsName,@RequestParam String lastName){
        return employeeService.searchEmployee(firsName,lastName);
    }

}
