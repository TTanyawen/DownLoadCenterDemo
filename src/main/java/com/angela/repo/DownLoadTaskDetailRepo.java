package com.angela.repo;

import com.angela.entity.DownLoadTaskDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DownLoadTaskDetailRepo extends JpaRepository<DownLoadTaskDetail, Long> {
    DownLoadTaskDetail findByTaskId(Long taskId);
}
