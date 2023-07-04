package pro.sky.collections.service;

import pro.sky.collections.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int salary, int departmentNum);

    Employee remove(String firstName, String lastName, int salary, int departmentNum);

    Employee find(String firstName, String lastName, int salary, int departmentNum);

    Collection<Employee> findAll();
}
