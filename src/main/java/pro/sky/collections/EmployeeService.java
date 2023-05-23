package pro.sky.collections;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeService() {
        this.employees = new HashMap<>();
    }
    public Employee addEmployee(String firstName, String lastName) {
        //логика реализации добавления сотрудника
    Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeStorageIsFullException("лист переполнен");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }
    public Employee removeEmployee(String firstName, String lastName) {
        //логика удаления сотрудника
        Employee employee = new Employee(firstName,lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException("такого сотрудника нет");
    }

    public Employee findEmployee(String firstName, String lastName) {
        //логика нахождения сотрудника
        Employee employee = new Employee(firstName,lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException("такого сотрудника нет");
    }

    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
