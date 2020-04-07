package com.example.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Description
 *
 * 想让服务器和客户端对话的，但是好像不行？这个连接只能传输一次信息？
 * @Author Radish
 * @Date 2020/3/17
 */

public class TalkServer {
    public static void main(String[] args) throws Exception {
        int port = 55533;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner in = new Scanner(System.in);
        System.out.println("服务器，你上线啦！给自己取个名字吧：");
        String serverName = in.next();
        Socket socket = null;
        try {
            socket = server.accept();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            OutputStream outputStream = socket.getOutputStream();

            outputStream.write(serverName.getBytes("UTF-8"));
            //首先获取客户端名称
            String clientName = "";
            while (reader.readLine()!= null) {
                clientName = reader.readLine();
                break;
            }

            System.out.println("你的客户端是：" + clientName);

            String line;
            while (true) {
                if ((line = reader.readLine()) != null) {
                    //服务器收到一条信息后，要给客户端发送一条信息
                    System.out.println(clientName + "：" + line);
                    String input = in.nextLine();
                    outputStream.write(input.getBytes("UTF-8"));
                    if ("bye".equals(input) && "bye".equals(line)) break;
                }
            }

            outputStream.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
            if (server != null) {
                server.close();
            }
        }


    }
}
