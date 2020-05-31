package com.wang.client;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 王一宁
 * @date 2020/5/31 13:03
 */
public class TcpClient {

    /**
     * 远端端口、ip、socket
     */
    private int remotePort;
    private InetAddress remoteIP;
    private Socket socket;

    public TcpClient(String ip, String port)throws IOException {
        this.remotePort=Integer.parseInt(port);
        this.remoteIP=InetAddress.getByName(ip);
        socket = new Socket();
    }

    /**
     * 数据发送方法
     */
    public void send(String msg) throws IOException {
        try {
            //构建一个数据报文。
            Socket socket = new Socket(remoteIP,remotePort);

            // 发送服务器的信息

            OutputStream out = socket.getOutputStream();

            String put = msg;
            PrintWriter pw = new PrintWriter(out);
            pw.println(put);
            pw.flush();

            out.close();
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    /**
     * 释放本地端口
     */
    public void close() throws IOException {
        if(socket!=null) {
            socket.close();
        }
    }

    public String receive() {
        if (socket != null){
            return "服务器已接受";
        }else{
            return "服务器连接失败";
        }

    }
}
