package com.radish.thinking.unit13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheReplacements {
    public static void main(String[] args) {
        String s = "  ?mmm   2  hhhhhhhhhhi  2xjewojcekpc";
        Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/",Pattern.DOTALL).matcher(s);
        if (mInput.find()) {
            s = mInput.group(1);
        }
        s = s.replaceAll(" {2,}"," ");
        s = s.replaceAll("(?m)^ +","");
        System.out.println(s);
        s = s.replaceFirst("[aeiou]","VOWEL1");
        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        while (m.find()) {
            m.appendReplacement(sbuf,m.group().toUpperCase());
            m.appendTail(sbuf);
            System.out.println(sbuf);
        }
    }
}
