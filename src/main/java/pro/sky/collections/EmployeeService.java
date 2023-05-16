package pro.sky.collections;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    public List<Employee> employeeList = new ArrayList<>();
    public final int MAX_EMPLOYEES = 10;

    public Employee addEmployee(String firstName, String lastName) {
        //логика реализации добавления сотрудника
    Employee employee = new Employee(firstName, lastName);
        if (employeeList.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("лист переполнен");
        }
    if (employeeList.contains(employee)) {
        throw new EmployeeAlreadyAddedException("сотрудник уже добавлен");
    }
        employeeList.add(employee);
    return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        //логика удаления сотрудника
        Employee employee = new Employee(firstName,lastName);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        } else throw new EmployeeNotFoundException("такого сотрудника нет");
    }

    public Employee findEmployee(String firstName, String lastName) {
        //логика нахождения сотрудника
        Employee employee = new Employee(firstName,lastName);
        if (employeeList.contains(employee)) {
            return employee;
        } else throw new EmployeeNotFoundException("такого сотрудника нет");
    }

    public List<Employee> findAll() {
        return employeeList;
    }
}
