package com.radish.io;

import com.radish.utils.MyUtils;

import java.math.BigDecimal;

/**
 * @Description
 * @Author Radish
 * @Date 2020/4/3
 */

public class Test {
    public static void main(String[] args) {
        /*Random random = new Random();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(random.nextInt(90) + 10);
        }*/


//        System.out.println(1 == new Integer(1));


        System.out.println(new BigDecimal(0.00).setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println(BigDecimal.ZERO);
        System.out.println(new BigDecimal("0.00"));
        System.out.println(new BigDecimal(0));
        System.out.println(new BigDecimal(0.00));

        int[] arr1 = new int[10];
        int[] arr2 = new int[20];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i;
        }
        System.arraycopy(arr2,5,arr1,1,5);

        MyUtils.print(arr2);
        MyUtils.print(arr1);
        /*Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int i = in.nextInt();
            //位运算算出一个两位数
            while (i > 1<<7) {
                i = i>>1;
            }
            System.out.println(i);
        }*/

        /*FileOutputStream out = null;
        FileInputStream in = null;
        try {
            out = new FileOutputStream(new File("111.txt"));
            out.write(1);
            in = new FileInputStream("111.txt");
            int read = in.read();
            System.out.println(read);
            File file = new File("111.txt");
            out.close();
            in.close();
            if (file.exists()) {
                file.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        //
        /*ReentrantLock lock = new ReentrantLock();
        String s = "hhhhh";
        byte[] bytes = s.getBytes();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        InputStreamReader inputStreamReader = new InputStreamReader(new ByteArrayInputStream(bytes));
//        FileOutputStream a = new FileOutputStream("a");

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(s.getBytes())));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
