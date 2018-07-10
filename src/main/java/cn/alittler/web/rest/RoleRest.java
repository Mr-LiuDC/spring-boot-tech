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
        Role role = roleService.save(name);
        return role;
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Integer id) {
        roleService.delete(id);
        return ResponseEntity.ok("删除成功");
    }

    @PutMapping
    public Role updateById(@RequestParam Integer id, @RequestParam String name) {
        Role role = roleService.update(id, name);
        return role;
    }

    @GetMapping("/{id}")
    public Role getById(@PathVariable Integer id) {
        Role role = roleService.findById(id);
        return role;
    }

    @GetMapping("/page")
    public Page<Role> getPage(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        Page<Role> page = roleService.getPage(pageNo, pageSize);
        return page;
    }

    @GetMapping
    public List<Role> getAll() {
        List<Role> list = roleService.findAll();
        return list;
    }

}
