package pro.sky.employeeweb.service;


import pro.sky.employeeweb.dto.Employee;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee searchEmployee(String firstName, String lastName);
}
