package com.radish.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/17
 */

public class TalkClient {
    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1";
        int port = 55533;
        Socket socket = null;
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("客户端，你已上线啦，请输入你的名字：");
            Scanner in = new Scanner(System.in);
            String clientName = in.next();

            outputStream.write(clientName.getBytes("UTF-8"));

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

            String serverName = "";

            while (reader.readLine() != null) {
                serverName = reader.readLine();
                break;
            }
            System.out.println("你的服务器是：" + serverName);

            String line;

            while (true) {
                if ((line = reader.readLine()) != null) {
                    System.out.println(serverName + "：" + line);
                    //输入，与服务器进行交流
                    String input = in.nextLine();
                    outputStream.write(input.getBytes("UTF-8"));

                    //如果俩人都说bye，就退出回话
                    if ("bye".equals(line) && "bye".equals(input)) break;
                }
            }


            outputStream.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }

    }
}
