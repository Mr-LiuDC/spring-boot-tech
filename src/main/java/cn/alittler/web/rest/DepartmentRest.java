package cn.alittler.web.rest;

import cn.alittler.entity.Department;
import cn.alittler.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LiuDeCai
 */
@RestController
@RequestMapping("/deps")
public class DepartmentRest {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentRest(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public Department create(@RequestParam String name) {
        Department department = departmentService.save(name);
        return department;
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Integer id) {
        departmentService.delete(id);
        return ResponseEntity.ok("删除成功");
    }

    @PutMapping
    public Department updateById(@RequestParam Integer id, @RequestParam String name) {
        Department department = departmentService.update(id, name);
        return department;
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Integer id) {
        Department department = departmentService.findById(id);
        return department;
    }

    @GetMapping("/page")
    public Page<Department> getPage(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        Page<Department> page = departmentService.getPage(pageNo, pageSize);
        return page;
    }

    @GetMapping
    public List<Department> getAll() {
        List<Department> list = departmentService.findAll();
        return list;
    }
}
