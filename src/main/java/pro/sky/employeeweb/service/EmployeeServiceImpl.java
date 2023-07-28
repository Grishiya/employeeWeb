package pro.sky.employeeweb.service;

import org.springframework.stereotype.Service;
import pro.sky.employeeweb.exception.EmployeeStorageIsFullException;
import pro.sky.employeeweb.dto.Employee;
import pro.sky.employeeweb.exception.EmployeeAlreadyAddedException;
import pro.sky.employeeweb.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees;
    private static final int EMPLOYEES_MAX_SIZE = 10;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() == EMPLOYEES_MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Превышен лимит сотрудников");

        }

        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("В компании уже есть такой сотрудник.");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);


        if (!employees.remove(employee)) {
            throw new EmployeeNotFoundException("Cотрудник не найден");
        }
return employee;
    }
@Override
    public Employee searchEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employee;
    }

}
