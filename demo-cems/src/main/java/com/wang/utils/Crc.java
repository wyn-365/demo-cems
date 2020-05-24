package com.wang.utils;

/**
 * CRC16位校验，取8字节作数据报校验
 */
public class Crc {
    public String Make_CRC(byte[] data){
        // 存储需要产生校验码的数据
        byte[] buf = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            buf[i] = data[i];
        }
        // 给字节数组赋值
        int len = buf.length;
        // 16位
        int crc = 0xFFFF;
        for (int pos = 0; pos < len; pos++) {
            if (buf[pos] < 0) {
                // 异或
                crc ^= (int) buf[pos] + 256;
                // crc
            } else {
                crc ^= (int) buf[pos];
            }
            for (int i = 8; i != 0; i--) {
                if ((crc & 0x0001) != 0) {
                    crc >>= 1;
                    crc ^= 0xA001;
                } else{
                    crc >>= 1;
                }
            }
        }
        String c = Integer.toHexString(crc);
        if (c.length() == 4) {
            c = c.substring(2, 4) + c.substring(0, 2);
        } else if (c.length() == 3) {
            c = "0" + c;
            c = c.substring(2, 4) + c.substring(0, 2);
        } else if (c.length() == 2) {
            c = "0" + c.substring(1, 2) + "0" + c.substring(0, 1);
        }
        return c.toUpperCase();
    }
}
