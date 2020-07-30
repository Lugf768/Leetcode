package com.lgf.string;

public class longestCommonPrefix {


    public static void main(String[] args) {
        String[] strings = {"flower","flow","flight", "sa"};
        String s = longestCommonPrefix1(strings);
        System.out.println(s);
    }

    public static String longestCommonPrefix1(String[] strs) {

        if(strs==null||strs.length==0){
            return "";
        }
        for(int i=1;i<strs.length;i++){
            //单次求取每个元素的公共前缀，将第一个元素作为参照，循环将第一个元素长度从后缩短一个判断
            while(strs[i].indexOf(strs[0])!=0){
                strs[0]=strs[0].substring(0, strs[0].length()-1);
                if(strs[0].isEmpty()) return "";
            }
        }
        return strs[0];

    }

}
