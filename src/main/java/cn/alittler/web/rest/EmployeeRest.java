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
                           @RequestParam List<Integer> roleId) {
        return employeeService.save(name, birthday, departmentId, roleId);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Integer id) {
        employeeService.delete(id);
        return ResponseEntity.ok("删除成功");
    }

    @PutMapping
    public Employee updateById(@RequestParam Integer id, @RequestParam String name, @RequestParam String birthday) {
        return employeeService.update(id, name, birthday);
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Integer id) {
        return employeeService.findById(id);
    }

    @GetMapping("/page")
    public Page<Employee> getPage(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        return employeeService.getPage(pageNo, pageSize);
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.findAll();
    }
}
