package com.gemframework.base.model.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "gem_user")
@EntityListeners(AuditingEntityListener.class)
public class User extends BasePo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, columnDefinition = "varchar(10) not null comment '用户名'")
    private String userName;

    @Column(name = "user_age", columnDefinition = "int not null comment '年龄'")
    private Integer userAge;

    @Column(name = "user_phone", columnDefinition = "varchar(11) not null comment '手机号'")
    private String userPhone;

    @Column(name = "create_time", columnDefinition = "datetime")
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @Column(name = "update_time", columnDefinition = "datetime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @LastModifiedDate
    private Date updateTime;
}
