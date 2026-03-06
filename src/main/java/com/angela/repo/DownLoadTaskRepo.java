package com.angela.repo;

import com.angela.entity.DownLoadTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DownLoadTaskRepo extends JpaRepository<DownLoadTask, Long> {
}
