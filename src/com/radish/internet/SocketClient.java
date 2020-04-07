package com.example.internet;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/17
 */

public class SocketClient {
    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1";
        int port = 55533;
        Socket socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        /*指定字符来关闭连接*/
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String message = in.nextLine();
            outputStream.write(message.getBytes("UTF-8"));
            if ("bye".equals(message)) break;
        }
        //通过shutdownOutput高速服务器已经发送完数据，后续只能接受数据
        socket.shutdownOutput();
        /*String message = "你好！大萝卜大大大萝卜的服务器！";
        outputStream.write(message.getBytes("UTF-8"));
        socket.shutdownOutput();*/

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            sb.append(new String(bytes,0,len,"UTF-8"));
        }
        System.out.println("get message from server: " + sb);



        //通道已经关闭了，不能再写了~
        /*while (in.hasNext()) {
            String message = in.nextLine();
            outputStream.write(message.getBytes("UTF-8"));
            if ("bye".equals(message)) break;
        }*/


        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
