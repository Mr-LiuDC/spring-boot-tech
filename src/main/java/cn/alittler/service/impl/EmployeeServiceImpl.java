package cn.alittler.service.impl;

import cn.alittler.entity.Employee;
import cn.alittler.repository.DepartmentRepository;
import cn.alittler.repository.EmployeeRepository;
import cn.alittler.repository.RoleRepository;
import cn.alittler.service.EmployeeService;
import cn.alittler.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author LiuDeCai
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;
    private RoleRepository roleRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository,
                               RoleRepository roleRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Employee save(String name, String birthday, Integer departmentId, List<Integer> roleId) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setBirthday(DateUtils.parseDateStr(birthday, "yyyy-MM-dd"));
        employee.setDepartment(departmentRepository.findOne(departmentId));
        employee.setRoles(roleRepository.findAll(roleId));
        employee.setCreateTime(new Date());
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.delete(id);
    }

    @Override
    public Employee update(Integer id, String name, String birthday) {
        Employee employee = employeeRepository.findOne(id);
        employee.setName(name);
        employee.setBirthday(DateUtils.parseDateStr(birthday, "yyyy-MM-dd"));
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public Page<Employee> getPage(Integer pageNo, Integer pageSize) {
        PageRequest pageRequest = new PageRequest(pageNo, pageSize);
        return employeeRepository.findAll(pageRequest);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

}
