package com.lgf.math;

public class isPalindrome {

    public static void main(String[] args) {
        boolean palindrome1 = isPalindrome1(132323231);
        System.out.println(palindrome1);
    }

    public static boolean isPalindrome1(int x) {
        if (x < 0){
            return false;
        }
        String xs = Integer.toString(x);
        char[] chars = xs.toCharArray();
        int i = 0, y = chars.length-1;
        while (i < y){
            if (chars[i] == chars[y]){
                i++;
                y--;
            }else {
                return false;
            }
        }
        return true;
    }

    //简单粗暴
    public boolean isPalindrome2(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }


    //比较两值
    public boolean isPalindrome3(int x) {
        if(x < 0)
            return false;
        int cur = 0;
        int num = x;
        while(num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }

}
