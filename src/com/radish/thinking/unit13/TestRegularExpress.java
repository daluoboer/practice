package com.radish.thinking.unit13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * "abcabcabcdefabcc"
 * "abc+"
 * "(abc)+"
 * "(abc){2,}"
 *
 *
 * "Java now has regular expressions"
 * "^Java"
 * "\Berg.*"
 * "n.w\s+h(a|i)s"
 * "s?"
 * "s*"
 * "s+"
 * "s{4}"
 * "s{1}"
 * "s{0,3}"
 *
 *
 * "Arline ate enght apples and one orange while Anita hadn't any"
 * "(?i)((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b"
 */
public class TestRegularExpress {
    public static void main(String[] args) {
        if (args.length > 2) {
            System.out.println("Usage:\njava TestRegularExpression " + "characterSequence regularExpression+");
            System.out.println();
//            System.exit(0);
        }
        System.out.println("Input: \"" + args[0]+"\"\n");
        int time = 0;
        for (String arg : args) {
            System.out.println("Regular expression: \"" + arg + "\"");
            Pattern p = Pattern.compile(arg);
            Matcher m = p.matcher(args[0]);
            while (m.find() && !m.group().equals("")) {
                time ++;
                System.out.println("Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1));
            }
            System.out.println();
        }
        System.out.println("共匹配：" + time + "次");
    }
}
