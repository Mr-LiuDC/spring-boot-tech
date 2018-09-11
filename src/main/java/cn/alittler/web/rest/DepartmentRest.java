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
        return departmentService.save(name);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Integer id) {
        departmentService.delete(id);
        return ResponseEntity.ok("删除成功");
    }

    @PutMapping
    public Department updateById(@RequestParam Integer id, @RequestParam String name) {
        return departmentService.update(id, name);
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Integer id) {
        return departmentService.findById(id);
    }

    @GetMapping("/page")
    public Page<Department> getPage(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        return departmentService.getPage(pageNo, pageSize);
    }

    @GetMapping
    public List<Department> getAll() {
        return departmentService.findAll();
    }
}
