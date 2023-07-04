package pro.sky.collections.service;

import pro.sky.collections.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DepartmentService {

    public Optional<Employee> findMaxSalaryByDepartment(Integer department);

    public Optional<Employee> findMinSalaryByDepartment(Integer department);

    public List<Employee> findEmployeeByDepartment(Integer department);

    public Map<Integer, List<Employee>> findAllEmployeeByDepartmentSeparation();
}
