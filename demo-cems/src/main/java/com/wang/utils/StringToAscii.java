package com.wang.utils;

/**
 * @author 15067
 */
public class StringToAscii {

    public String StrToAsc(String str) {

        StringBuilder sb = new StringBuilder();
        char[] ch = str.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            //数据段长度的话,特定字段下不算标点符号的ASCII码长度(cp=&&...&&)
            sb.append((int)ch[i]);
        }

        System.out.println(sb);

        // 把数据段这一部分的字符串转为ASCII码
        String x = String.format("%04d", sb.length());

        // x得到的是String类型的,转成int型0会消失--如果不用format方法，需要自定义方法
        return x;
    }
}
