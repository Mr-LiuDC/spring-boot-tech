package cn.alittler.repository;

import cn.alittler.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author LiuDeCai
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
