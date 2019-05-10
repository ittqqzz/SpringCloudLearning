package tqz.cloud.service;


import com.tqz.cloud.entities.Dept;

import java.util.List;

public interface DeptService {
    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();
}
