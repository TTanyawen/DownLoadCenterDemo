package com.angela.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="t_download_task_0306")
public class DownLoadTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="file_name")
    private String fileName;

    private Integer status;
    @Column(name="fail_reason")
    private String failReason;
    @Column(name="last_id")
    private Long lastId;


}

//CREATE TABLE t_download_task_0306 (
//        id BIGINT PRIMARY KEY AUTO_INCREMENT,
//        file_name VARCHAR(255) NOT NULL,
        //status TINYINT NOT NULL COMMENT '0-待处理 1-处理中 2-成功 3-失败',
        //fail_reason VARCHAR(500),
        //last_id BIGINT DEFAULT 0 COMMENT '断点续传记录的最后一条ID'
//        ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;