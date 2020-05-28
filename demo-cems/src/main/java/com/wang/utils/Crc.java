package com.wang.utils;

/**
 * CRC16位校验，取8字节作数据报校验
 * @author 尹
 */
public class Crc {
    public String Make_CRC(byte[] data){
        // 存储需要产生校验码的数据
        byte[] buf = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            buf[i] = data[i];
        }
        // 字节数组赋值
        int len = buf.length;
        // 1.生成一个16位寄存器，所有数位均为1
        int crc = 0xFFFF;
        // 2-6是一个嵌套循环，3-5是内层循环
        // 直到所有字节完成运算
        for (int pos = 0; pos < len; pos++) {
            // 2.取被校验的一个字节与16位寄存器异或运算，结果放入16位寄存器
            crc ^= (int) buf[pos];
            // 3.4,5步是内层循环
            // 5.移出8位为止
            for (int i = 8; i != 0; i--) {
                //3.将16位寄存器右移一位
                //4.若移出的位数为1，则移位后与0xA001异或
                if ((crc & 0x0001) != 0) {
                    crc>>=1;
                    crc ^= 0xA001;
                }
                else
                {crc>>=1;}
            }
        }
        String c = Integer.toHexString(crc);
        return c.toUpperCase();
    }

}
