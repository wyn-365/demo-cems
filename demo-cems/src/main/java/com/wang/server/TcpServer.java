package com.wang.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 王一宁
 * @date 2020/5/31 12:57
 */
public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8899);
        // 等待连接
        Socket client = server.accept();
        // 接受客户端的输入
        Scanner scan = new Scanner(client.getInputStream());
        scan.useDelimiter("\n");
        // 对客户端的回应
        PrintStream out = new PrintStream(client.getOutputStream());
        boolean flag = true;
        while(flag) {
            // pandaUN客户达UN是否是有数据
            if(scan.hasNext()) {
                // 防止有空格出现
                String str = scan.next().trim();
                if("byebye".equals(str)) {
                    out.println("byebye!!!");
                    // 退出循环
                    flag = false;
                    break;
                }
                // 做出回应
                out.println("Server："+str);
                System.out.println(str);
            }
        }
        out.close();
        scan.close();
        server.close();
    }
}
