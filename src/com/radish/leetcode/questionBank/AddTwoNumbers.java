package com.radish.leetcode.questionBank;

//错误原因：01213，前边的0自动被省去了导致错误
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = getNodeByNumber(2453);
        ListNode l2 = getNodeByNumber(864);
        ListNode node = addTwoNumbers(l1,l2);
//        System.out.println(getNumber(node,getLen(node,1)));
        int number = getNumber(getNodeByNumber(4010), getLen(getNodeByNumber(4010),1));
        System.out.println(number);
    }

    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        int len1 = getLen(l1,1);
        int len2 = getLen(l2,1);

        int number1 = getNumber(l1,len1);
        int number2 = getNumber(l2,len2);

        int sum = number1 + number2;
        ListNode node = getNodeByNumber(sum);
        return node;
    }

    //根据正整数获取ListNode，是从最低位开始存储数字啊
    public static ListNode getNodeByNumber(int number){
        int cur = number%10;
        ListNode node = new ListNode(cur);
        if(number >= 10){
            node.next = getNodeByNumber(number/10);
        }
        return node;
    }

    //获取正整数的位数
    public static int getLenByNumber(int number){
        int len = 0;
        int result = number;
        for(;result>0;len++) {
            result = result/10;
        }
        return len;
    }

    //错误原因：01213，前边的0自动被省去了导致错误
    public static int getNumber(ListNode node,int length){
        if(node.next != null){
            return node.val*(int)(Math.pow(10,length-1))+getNumber(node.next,length-1);
        }
        else{
            return node.val*(int)(Math.pow(10,length-1));
        }
    }

    public static int getLen(ListNode node,int len){
        if(node.next != null){
            return getLen(node.next,len+1);
        }
        else {
            return len;
        }
    }
}
