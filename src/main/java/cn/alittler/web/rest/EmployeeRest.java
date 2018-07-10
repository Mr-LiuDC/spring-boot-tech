package cn.alittler.web.rest;

import cn.alittler.entity.Employee;
import cn.alittler.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LiuDeCai
 */
@RestController
@RequestMapping("/emps")
public class EmployeeRest {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRest(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee create(@RequestParam String name, @RequestParam String birthday, @RequestParam Integer departmentId,
                           @RequestParam Integer roleId) {
        Employee employee = employeeService.save(name, birthday, departmentId, roleId);
        return employee;
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Integer id) {
        employeeService.delete(id);
        return ResponseEntity.ok("删除成功");
    }

    @PutMapping
    public Employee updateById(@RequestParam Integer id, @RequestParam String name, @RequestParam String birthday) {
        Employee employee = employeeService.update(id, name, birthday);
        return employee;
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        return employee;
    }

    @GetMapping("/page")
    public Page<Employee> getPage(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        Page<Employee> page = employeeService.getPage(pageNo, pageSize);
        return page;
    }

    @GetMapping
    public List<Employee> getAll() {
        List<Employee> list = employeeService.findAll();
        return list;
    }
}
