package com.wang.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author 王一宁
 * @date 2020/4/29 15:00
 */
public class UdpServer {
    private int port = 6666;
    private DatagramSocket socket;

    /**
     * 方法入口
     * @param args
     * @throws IOException
     */
    public static void main(String[] args)throws IOException {
        new UdpServer().service();
    }

    /**
     * 启动服务器的方法
     * @throws IOException
     */
    public UdpServer() throws IOException{
        socket =new DatagramSocket(port);
        System.out.println("UDP服务器已启动.....");
    }

    /**
     * 打印消息
     * @param msg
     * @return
     */
    public String echo(String msg){
        return "server ："+msg;
    }

    /**
     * 监听客户端消息的方法
     */
    public void service(){
        while(true){
            try{
                DatagramPacket packet =new DatagramPacket(new byte[1024],1024);
                socket.receive(packet);
                String msg = new String(packet.getData(),0,packet.getLength(),"UTF8");
                System.out.println(packet.getAddress()+" : "+packet.getPort()+":"+ packet.getLength() +">"+msg);
                packet.setData(echo(msg).getBytes("UTF8"));
                socket.send(packet);
            }catch(IOException e){
                System.out.println(e);
            }
        }
    }

}
