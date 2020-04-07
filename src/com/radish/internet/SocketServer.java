package com.radish.internet;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/17
 */

public class SocketServer {
    public static void main(String[] args) throws Exception {
        int port = 55533;
        ServerSocket server = new ServerSocket(port);
        System.out.println("server将一直等待连接的到来");
        //
        Socket socket = server.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            sb.append(new String(bytes,0,len,"UTF-8"));
        }
        System.out.println("get message from client: " + sb);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello, Client! I get the message.".getBytes("UTF-8"));
        inputStream.close();
        outputStream.close();
        socket.close();
        server.close();

        /*约定一个字符作为结尾*/
        /*Socket socket = server.accept();
        BufferedReader read = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = read.readLine()) != null && !"end".equals(line)) {
            sb.append(line);
        }
        System.out.println("get message from Client: " + sb);
        OutputStream outputStream = socket.getOutputStream();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String message = in.nextLine();
            outputStream.write(message.getBytes("UTF-8"));
            if ("bye".equals(message)) break;
        }

        //sb = new StringBuilder();

       *//* while (read.readLine() == null) {

        }*//*

        *//*while ((line = read.readLine()) != null && !"end".equals(line)) {
            sb.append(line);
        }*//*

        outputStream.close();
        read.close();
        socket.close();
        server.close();*/
    }
}
