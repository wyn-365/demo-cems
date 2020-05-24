package com.wang.utils;

import com.wang.entity.Ini4jFileDo;
import org.ini4j.Ini;
import org.ini4j.Profile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王一宁
 * @date 2020/4/28 22:33
 * 读取配置文件的方法
 */
public class ReadIni {

    public static Ini4jFileDo readIniFile() throws Exception {
        /**
         * 1.初始化加载配置文件
         */
        // 配置文件的位置
        File iniFile = new File("D:\\APP\\IDEA\\workplace\\demo-cems\\src\\main\\resources\\fmCemsSrv05.ini");
        Map<String, List<String>> fileContent = new HashMap<String, List<String>>();
        // 1.通信协议数据
        fileContent.put("protocol", Arrays.asList("ID","PW","ST","NEWS","HAND",
                "UPLOAD_TIME","UPLOAD_TIME","UPLOAD_TIME","SERIAL_NUMBER",
                "SERIAL_BAUD","SERIAL_DATA","SERIAL_STOP","SERIAL_CHECK",
                "LOCAL_UDP_IP","LOCAL_UDP_PORT","OPPOSITE_UDP_IP",
                "OPPOSITE_UDP_PORT","LOCAL_TCP_IP","OPPOSITE_TCP_IP",
                "OPPOSITE_TCP_PORT"));

        // 2.数据库连接数据
        fileContent.put("SqlServer",Arrays.asList("USER","PASSWORD","URL"));

        // 3.实时数据
        fileContent.put("realtimedata",Arrays.asList("Rtd0"));

        // 4.历史数据
        fileContent.put("historydata1",Arrays.asList("NO0", "NO1", "NO2", "NO3", "NO4", "NO5", "NO6",
                "NO7", "NO8", "NO9", "NO10", "NO11", "NO12", "NO13", "NO14", "NO15", "NO16", "NO17",
                "NO18", "NO19", "NO20", "NO21", "NO22", "NO23", "NO24", "NO25", "NO26", "NO27",
                "NO28", "NO29", "NO30", "NO31", "NO32", "NO33", "NO34", "NO35", "NO36", "NO37",
                "NO38", "NO39", "NO40", "NO41", "NO42", "NO43", "NO44", "NO45", "NO46", "NO47",
                "NO48", "NO49"));

        Ini4jFileDo fileDo = new Ini4jFileDo();
        Ini ini = new Ini();
        ini.load(iniFile);
        Profile.Section section = null;
        Field field = null;
        for (String key : fileContent.keySet()) {
            section = ini.get(key);
            for (String value : fileContent.get(key)) {
                field = fileDo.getClass().getDeclaredField(value);
                field.setAccessible(true);
                field.set(fileDo, section.get(value));
            }
        }
        return fileDo;
    }


    public static void main(String[] args) throws Exception {
        Ini4jFileDo ini4jFileDo = readIniFile();
        System.out.println("ini"+ini4jFileDo);
    }
}
