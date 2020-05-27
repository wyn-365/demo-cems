package com.wang.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author 王一宁
 * @date 2020/4/29 15:01
 */
public class UdpClient {


    /**
     * 远端端口、ip、socket
     */
    private int remotePort;
    private InetAddress remoteIP;
    private DatagramSocket socket;

    /**
     * 创建套接字的构造方法
     * @param ip
     * @param port
     * @throws IOException
     */
    public UdpClient(String ip, String port)throws IOException {
        this.remotePort=Integer.parseInt(port);
        this.remoteIP=InetAddress.getByName(ip);

        //创建一个UDP套接字，与本地任意一个未使用的UDP端口绑定
        socket = new DatagramSocket();
        //与本地一个固定的UDP端口绑定
        //socket=new DatagramSocket(9000);
    }

    /**
     * 数据发送方法
     */
    public void send(String msg){
        try {
            //先准备一个待发送的数据报
            byte[] outputData = msg.getBytes("GB2312");
            //构建一个数据报文。
            DatagramPacket outputPacket=new DatagramPacket(outputData,
                    outputData.length,remoteIP,remotePort);
            //给EchoUDPServer发送数据报
            socket.send(outputPacket);
        } catch (IOException ex) { }
    }

    /**
     * 数据的接收方法。
     */
    public String receive(){
        String msg;
        //先准备一个空数据报文
        DatagramPacket inputPacket=new DatagramPacket(new byte[1024],1024);
        try {
            //阻塞语句，有数据就装包，以装完或装满为此.
            socket.receive(inputPacket);
            //从报文中取出字节数据并装饰成字符。
            msg = new String(inputPacket.getData(),
                    0,inputPacket.getLength(),"GB2312");
        } catch (IOException ex) {
            msg = null;
        }
        return msg;
    }

    /**
     * 释放本地端口
     */
    public void close(){
        if(socket!=null) {
            socket.close();
        }
    }
}

