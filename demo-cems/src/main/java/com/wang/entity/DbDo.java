package com.wang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 王一宁
 * @date 2020/5/5 14:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DbDo {
    /**
     * 数据库连接字段
     */
    private String USER;
    private String PASSWORD;
    private String URL;
    private String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
}
