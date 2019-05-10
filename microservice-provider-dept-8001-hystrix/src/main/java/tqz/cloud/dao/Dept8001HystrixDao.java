package tqz.cloud.dao;

import com.tqz.cloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Dept8001HystrixDao {
    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
