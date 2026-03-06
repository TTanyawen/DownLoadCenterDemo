package com.angela.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="t_user_0306")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
}
//CREATE TABLE t_user_0306 (
//        id BIGINT PRIMARY KEY AUTO_INCREMENT,
//        name VARCHAR(100) NOT NULL,
//age INT
//) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;