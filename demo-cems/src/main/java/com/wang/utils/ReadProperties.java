package com.wang.utils;

import com.wang.entity.DbDo;
import com.wang.entity.ProtocolDo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author 王一宁
 * @date 2020/5/5 12:52
 */
public class ReadProperties {

    /**
     * 读取数据库的方法
     * @return
     */
    public DbDo readDB() throws Exception {
        InputStream inputStream = ReadProperties.class.getClassLoader().getResourceAsStream("db.properties");
        Properties p = new Properties();
        try {
            p.load(inputStream);
        } catch (IOException e1) {
            e1.printStackTrace();
        }finally {
            inputStream.close();
        }
        String url = p.getProperty("url");
        String user = p.getProperty("user");
        String password = p.getProperty("password");
        System.out.println("url:"+p.getProperty("url")+",user:"+p.getProperty("user"));
        DbDo dbDo = new DbDo();
        dbDo.setURL(url);
        dbDo.setUSER(user);
        dbDo.setPASSWORD(password);
        return dbDo;
    }

    /**
     * 读取协议的方法
     * @return
     */
    public ProtocolDo readProtocol() throws Exception {
        InputStream inputStream = ReadProperties.class.getClassLoader().getResourceAsStream("protocol.properties");
        Properties p = new Properties();
        try {
            p.load(inputStream);
        } catch (IOException e1) {
            e1.printStackTrace();
        }finally {
            inputStream.close();
        }
        ProtocolDo protocolDo = new ProtocolDo();

        String ID = p.getProperty("ID");
        String PW = p.getProperty("PW");
        String ST = p.getProperty("ST");
        String UPLOAD_TIME = p.getProperty("UPLOAD_TIME");
        String NEWS = p.getProperty("NEWS");
        String HAND = p.getProperty("HAND");
        String SERIAL_NUMBER = p.getProperty("SERIAL_NUMBER");
        String SERIAL_BAUD = p.getProperty("SERIAL_BAUD");
        String SERIAL_DATA = p.getProperty("SERIAL_DATA");
        String SERIAL_STOP = p.getProperty("SERIAL_STOP");
        String SERIAL_CHECK = p.getProperty("SERIAL_CHECK");
        String LOCAL_UDP_IP = p.getProperty("LOCAL_UDP_IP");
        String LOCAL_UDP_PORT = p.getProperty("LOCAL_UDP_PORT");
        String OPPOSITE_UDP_PORT = p.getProperty("OPPOSITE_UDP_PORT");
        String OPPOSITE_UDP_IP = p.getProperty("OPPOSITE_UDP_IP");
        String LOCAL_TCP_IP = p.getProperty("LOCAL_TCP_IP");
        String OPPOSITE_TCP_IP = p.getProperty("OPPOSITE_TCP_IP");
        String OPPOSITE_TCP_PORT = p.getProperty("OPPOSITE_TCP_PORT");

        protocolDo.setID(ID);
        protocolDo.setPW(PW);
        protocolDo.setST(ST);
        protocolDo.setUPLOAD_TIME(UPLOAD_TIME);
        protocolDo.setNEWS(NEWS);
        protocolDo.setHAND(HAND);
        protocolDo.setSERIAL_NUMBER(SERIAL_NUMBER);
        protocolDo.setSERIAL_BAUD(SERIAL_BAUD);
        protocolDo.setSERIAL_DATA(SERIAL_DATA);
        protocolDo.setSERIAL_STOP(SERIAL_STOP);
        protocolDo.setSERIAL_CHECK(SERIAL_CHECK);
        protocolDo.setLOCAL_UDP_IP(LOCAL_UDP_IP);
        protocolDo.setLOCAL_UDP_PORT(LOCAL_UDP_PORT);
        protocolDo.setOPPOSITE_UDP_PORT(OPPOSITE_UDP_PORT);
        protocolDo.setOPPOSITE_UDP_IP(OPPOSITE_UDP_IP);
        protocolDo.setOPPOSITE_TCP_IP(OPPOSITE_TCP_IP);
        protocolDo.setOPPOSITE_TCP_PORT(OPPOSITE_TCP_PORT);
        protocolDo.setLOCAL_TCP_IP(LOCAL_TCP_IP);

        return protocolDo;
    }


    /**
     * 数据表编码
     * @return
     */
    public Map<String,String> readCode() throws Exception {
        InputStream inputStream = ReadProperties.class.getClassLoader().getResourceAsStream("db.properties");
        BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
        Properties props = new Properties();
        try {
            props.load(bf);
        } catch (IOException e1) {
            e1.printStackTrace();
        }finally {
            inputStream.close();
        }
        Map<String,String> map = new HashMap<String, String>();
        Iterator<String> iterator = props.stringPropertyNames().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            map.put(key,props.getProperty(key));
        }
        map.remove("url");
        map.remove("user");
        map.remove("password");
        System.out.println(map);

        return map;
    }

    /**
     * 数据字段与编码的对应
     * @return
     */
    public Map<String,String> readTable() throws Exception {
        InputStream inputStream = ReadProperties.class.getClassLoader().getResourceAsStream("table.properties");
        Properties props = new Properties();
        try {
            props.load(inputStream);
        } catch (IOException e1) {
            e1.printStackTrace();
        }finally {
            inputStream.close();
        }
        Map<String,String> map = new HashMap<>();
        Iterator<String> iterator = props.stringPropertyNames().iterator();

        while (iterator.hasNext()){
            String key = iterator.next();
            map.put(key,props.getProperty(key));
        }

        return map;
    }
}
