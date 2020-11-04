package com.radish.leetcode.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description ABC
 * @Author Radish
 * @Date 2020-10-30 19:44
 */
public class ABC {
    public static void main(String[] args) {
        ABC abc = new ABC();
//        List<String> ips = abc.restoreIpAddresses("0000");
//        List<String> ips = abc.restoreIpAddresses("25525511135");
//        List<String> ips = abc.restoreIpAddresses("1111");
//        List<String> ips = abc.restoreIpAddresses("101023");
        List<String> ips = abc.restoreIpAddresses("010010");
        System.out.println(ips);
    }

    /**
     * 93. 复原IP地址
     * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
     *
     * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     *
     * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "25525511135"
     * 输出：["255.255.11.135","255.255.111.35"]
     * 示例 2：
     *
     * 输入：s = "0000"
     * 输出：["0.0.0.0"]
     * 示例 3：
     *
     * 输入：s = "1111"
     * 输出：["1.1.1.1"]
     * 示例 4：
     *
     * 输入：s = "010010"
     * 输出：["0.10.0.10","0.100.1.0"]
     * 示例 5：
     *
     * 输入：s = "101023"
     * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
     *
     *
     * 提示：
     *
     * 0 <= s.length <= 3000
     * s 仅由数字组成
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        //复原IP地址就是回溯啊，先获取第一位可以是啥，然后剩下的能否组成剩下的位
        List<String> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        getIps(s,path, res);
        return res;
    }

    private void getIps(String s, LinkedList<Integer> path, List<String> res) {
        if (path.size() == 4 && s.length() == 0) {
            //一个有效IP
            StringBuffer buffer = new StringBuffer();
            Iterator<Integer> iterator = path.iterator();
            while (iterator.hasNext()) {
                buffer.append(iterator.next() + ".");
            }
            String substring = buffer.substring(0, buffer.length()-1);
            res.add(substring);
            return;
        } else if (path.size() == 4 || s.length() == 0) return;

        //如果第一位是0，只能它自己一位，（不能有前导0）
        //如果第一位不是0，可以有两位或者3位，3位必须<=255
        if (s.charAt(0) != '0') {
            for (int i = 1; i <= 3 && i <= s.length(); i++) {
                Integer cur = Integer.valueOf(s.substring(0, i));
                if (cur > 255) break;
                path.addLast(cur);
                getIps(s.substring(i),path,res);
                path.removeLast();
            }
        } else {
            path.addLast(0);
            getIps(s.substring(1),path,res);
            path.removeLast();
        }
    }

    public List<String> getIps(String ip) {
        List<String> res = new ArrayList<>();
        if (ip.length() > 12 || ip.length() < 4) return res;
        char[] chars = ip.toCharArray();
        for (int i = 0; i < 3; i++) {
            String a = ip.substring(0, i+1);
            if (valid(a)) continue;
            for (int j = i+1; j < i+3; j++) {
                String b = ip.substring(i + 1, j + 1);
                if (valid(b)) continue;
                for (int k = j+1; k < j+3; k++) {
                    String c = ip.substring(j + 1, k + 1);
                    if (valid(c)) continue;
                    for (int m = k+1; m < k+3; m++) {
                        String d = ip.substring(m + 1, j + 1);
                        if (valid(d)) continue;
                        res.add(a + "." + "b" + "." + "d");
                    }
                }
            }
        }
        return res;
    }

    public boolean valid(String a) {
        if (Integer.valueOf(a) > 255 || (a.length() > 1 && a.startsWith("0"))) return false;
        return true;
    }
}
