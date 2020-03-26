/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Title: DadabaseRepository.java
 * @Package: com.gemframework.gembasic.repository
 * @Date: 2019-12-05 22:07:32
 * @Version: v1.0
 * @Description: 读取数据库Schema信息

 * @Author: zhangys
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
@NoRepositoryBean //不要暴露出来，数据库中没有表和这个接口匹配
public interface DatabaseRepository<T,ID extends Serializable> extends JpaRepository<T,ID> {

    @Query(value = "select table_name tableName, engine, table_collation tableCollation,table_comment " +
            "tableComment, create_time createTime from information_schema.tables " +
            "where table_schema = (select database()) AND (table_name LIKE " +
            "CONCAT('%',:tableName,'%') OR :tableName IS NULL ) " +
            "order by create_time desc " +
            "LIMIT :page,:size",
            nativeQuery = true)
    List<Map<String, String>> findAllTablesByName(@Param("tableName") String tableName,@Param("page") int page,@Param("size") int size);

    @Query(value = "select table_name tableName, engine, table_collation tableCollation,table_comment " +
            "tableComment, create_time createTime from information_schema.tables " +
            "where table_schema = (select database()) AND table_name = :tableName",
            nativeQuery = true)
    Map<String, String> getTablesByName(@Param("tableName") String tableName);

    @Query(value = "select count(*) as ct from information_schema.tables " +
            "where table_schema = (select database()) AND (table_name LIKE " +
            "CONCAT('%',:tableName,'%') OR :tableName IS NULL )",
            nativeQuery = true)
    Long findAllTablesCount(@Param("tableName") String tableName);


    @Query(value = "select column_name columnName, data_type dataType, " +
            "column_comment columnComment, column_key columnKey, extra " +
            "from information_schema.columns " +
            "where table_schema = (select database()) " +
            "AND (table_name = :tableName OR :tableName IS NULL) ",
            nativeQuery = true)
    List<Map<String, String>> findAllColumnsByTableName(@Param("tableName") String tableName);
}
