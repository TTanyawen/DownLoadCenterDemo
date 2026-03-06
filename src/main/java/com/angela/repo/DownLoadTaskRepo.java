package com.angela.repo;

import com.angela.entity.DownLoadTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DownLoadTaskRepo extends JpaRepository<DownLoadTask, Long> {
    //根据status 查询
    List<DownLoadTask> findByStatus(Integer status);
}
