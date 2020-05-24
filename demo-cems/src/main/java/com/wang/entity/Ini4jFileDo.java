package com.wang.entity;

import com.sun.scenario.effect.impl.prism.PrImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author 王一宁
 * @date 2020/4/28 22:40
 * 配置文件的数据对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ini4jFileDo {
    /**
     * 通信协议封装
     */
    private String ID;
    private String PW;
    private String ST;
    private String UPLOAD_TIME;
    private String NEWS;
    private String HAND;
    private String SERIAL_NUMBER;
    private String SERIAL_BAUD;
    private String SERIAL_DATA;
    private String SERIAL_STOP;
    private String SERIAL_CHECK;
    private String LOCAL_UDP_IP;
    private String LOCAL_UDP_PORT;
    private String OPPOSITE_UDP_IP;
    private String OPPOSITE_UDP_PORT;
    private String LOCAL_TCP_IP;
    private String OPPOSITE_TCP_IP;
    private String OPPOSITE_TCP_PORT;
    /**
     * 数据库连接字段
     */
    private String USER;
    private String PASSWORD;
    private String URL;
    private String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    /**
     * 实时数据
     */
    private String Rtd0;
    /**
     * 历史数据
     */
    private String NO0;
    private String NO1;
    private String NO2;
    private String NO3;
    private String NO4;
    private String NO5;
    private String NO6;
    private String NO7;
    private String NO8;
    private String NO9;
    private String NO10;
    private String NO11;
    private String NO12;
    private String NO13;
    private String NO14;
    private String NO15;
    private String NO16;
    private String NO17;
    private String NO18;
    private String NO19;
    private String NO20;
    private String NO21;
    private String NO22;
    private String NO23;
    private String NO24;
    private String NO25;
    private String NO26;
    private String NO27;
    private String NO28;
    private String NO29;
    private String NO30;
    private String NO31;
    private String NO32;
    private String NO33;
    private String NO34;
    private String NO35;
    private String NO36;
    private String NO37;
    private String NO38;
    private String NO39;
    private String NO40;
    private String NO41;
    private String NO42;
    private String NO43;
    private String NO44;
    private String NO45;
    private String NO46;
    private String NO47;
    private String NO48;
    private String NO49;
}
