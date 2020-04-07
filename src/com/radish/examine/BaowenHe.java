package com.radish.examine;

import java.util.Scanner;

/**
 * @Description
 * 报文转义功能
 * 报文中如果出现0x0A,转义成两个字节0x12 0x34,如果出现0x0B,转义成两个字节0xAB,0xCD,其他报文保持不变
 * 输出的第一个字节为报文长度（包含它自己）
 * 就是如果输入A就转义成12 34，如果输入B就转义成AB CD
 *
 * @Author 这个是别人写的，拿过来看一看
 * @Date 2020/3/16
 */

public class BaowenHe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] strArr = str.split(" ");
        String strOut = "";
        int countNum = Integer.parseInt(strArr[0], 16);
        for(int i=1; i<strArr.length; i++){
            if(strArr[i].equals("A")){
                strOut += "12";
                strOut += " ";
                strOut +="34";
                strOut += " ";
                countNum += 1;
            }
            else  if(strArr[i].equals("B")){
                strOut += "AB";
                strOut += " ";
                strOut +="CD";
                strOut += " ";
                countNum += 1;
            }
            else{
                strOut += strArr[i];
                strOut += " ";
            }
        }
        String result = Integer.toHexString(countNum).toUpperCase() + " " + strOut.trim();
        System.out.println(result);
    }
}
