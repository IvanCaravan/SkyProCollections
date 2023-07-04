package pro.sky.collections.service;

import org.springframework.stereotype.Service;
import pro.sky.collections.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Override
    public Optional<Employee> findMaxSalaryByDepartment(Integer department) {
        return employeeService.findAll().stream().filter(p -> p.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary));
    }
    @Override
    public Optional<Employee> findMinSalaryByDepartment(Integer department) {
        return employeeService.findAll().stream().filter(p -> p.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary));
    }



    @Override
    public List<Employee> findEmployeeByDepartment(Integer department) {
        return employeeService.findAll().stream().filter(p -> p.getDepartment() == department)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Map<Integer, List<Employee>> findAllEmployeeByDepartmentSeparation() {
        Map<Integer, List<Employee>> collect = employeeService.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return collect;
    }
}
