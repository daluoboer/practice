package com.radish.thinking.unit13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrep {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java JGrep file regex");
            System.exit(0);
        }
        System.out.println(args.length);
        System.out.println(args[1]);
        Pattern p = Pattern.compile(args[1]);
        int index = 0;
        Matcher m = p.matcher("");
        for (String line : new String[]{"JGrep.java","jx0iewjfddoe02o3","tjikjd","sa  ,Saa apple skip skip"}) {
            //为啥都匹配不了啊？",Saa"," skip"不都应该匹配吗
            m.reset(line);
            while (m.find()) {
                System.out.println(index++ + ": " + m.group() + ": " + m.start());
            }
        }
    }
}
