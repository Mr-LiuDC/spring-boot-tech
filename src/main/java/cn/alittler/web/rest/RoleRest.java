package cn.alittler.web.rest;

import cn.alittler.entity.Role;
import cn.alittler.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LiuDeCai
 */
@RestController
@RequestMapping("/role")
public class RoleRest {

    private RoleService roleService;

    @Autowired
    public RoleRest(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public Role create(@RequestParam String name) {
        return roleService.save(name);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Integer id) {
        roleService.delete(id);
        return ResponseEntity.ok("删除成功");
    }

    @PutMapping
    public Role updateById(@RequestParam Integer id, @RequestParam String name) {
        return roleService.update(id, name);
    }

    @GetMapping("/{id}")
    public Role getById(@PathVariable Integer id) {
        return roleService.findById(id);
    }

    @GetMapping("/page")
    public Page<Role> getPage(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        return roleService.getPage(pageNo, pageSize);
    }

    @GetMapping
    public List<Role> getAll() {
        return roleService.findAll();
    }

}
