package com.wang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 王一宁
 * @date 2020/5/17 14:04
 * 协议传输的实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProtocolDo {
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
}
