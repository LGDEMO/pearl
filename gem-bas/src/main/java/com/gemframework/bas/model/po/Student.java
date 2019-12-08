package com.gemframework.bas.model.po;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "gem_student")
public class Student {

    /**
     * 声明id 自增
     */
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(nullable = true)
    private int age;
    @Column(nullable = true)
    private String address;

    private String collage;

    private String sex;
}
