package com.angela.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="t_download_task_detail_0306")
public class DownLoadTaskDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="task_id")
    private Long taskId;
    @Column(name="sql_text")
    private String sqlText;
    @Column(name="column_model")
    private String columnModel;

}
//CREATE TABLE t_download_task_detail_0306 (
//        id BIGINT PRIMARY KEY AUTO_INCREMENT,
//        task_id BIGINT NOT NULL,
//        sql_text TEXT NOT NULL,
//        column_model TEXT
//) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;