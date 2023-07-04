package pro.sky.collections.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collections.model.Employee;
import pro.sky.collections.service.DepartmentService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "max-salary")
    public Optional<Employee> findMaxSalaryByDepartment(@RequestParam("departmentId") Integer department) {
        return departmentService.findMaxSalaryByDepartment(department);
    }

    @GetMapping(path = "min-salary")
    public Optional<Employee> findMinSalaryByDepartment(@RequestParam("departmentId") Integer department) {
        return departmentService.findMinSalaryByDepartment(department);
    }

    @GetMapping(value = "/all", params = {"departmentId"})
    public List<Employee> findEmployeeByDepartment(@RequestParam("departmentId") Integer department) {
        return departmentService.findEmployeeByDepartment(department);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> findAllEmployeeByDepartmentSeparation() {
        return departmentService.findAllEmployeeByDepartmentSeparation();
    }
}
