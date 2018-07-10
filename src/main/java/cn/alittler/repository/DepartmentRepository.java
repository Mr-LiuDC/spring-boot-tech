package cn.alittler.repository;

import cn.alittler.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author LiuDeCai
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
