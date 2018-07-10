package cn.alittler.service;

import cn.alittler.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author LiuDeCai
 */
public interface EmployeeService {

    /**
     * 保存
     *
     * @param name
     * @param birthday
     * @param departmentId
     * @param roleId
     * @return
     */
    Employee save(String name, String birthday, Integer departmentId, List<Integer> roleId);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Integer id);

    /**
     * 更新
     *
     * @param id
     * @param name
     * @param birthday
     * @return
     */
    Employee update(Integer id, String name, String birthday);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    Employee findById(Integer id);

    /**
     * 分页查询
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<Employee> getPage(Integer pageNo, Integer pageSize);

    /**
     * 查询所有
     *
     * @return
     */
    List<Employee> findAll();

}
