package com.lgf.array;

public class replaceElements {

    public static void main(String[] args) {
        int[] a ={17,18,5,4,6,1};
        int[] ints = replaceElements2(a);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    //时间复杂度较高
    public static int[] replaceElements1(int[] arr) {
        if (arr.length == 0){
            return arr;
        }else if (arr.length == 1){
            arr[0] = -1;
            return arr;
        }else {
            int max = -1;
            for (int i = 0; i < arr.length; i++){
                for (int j = i + 1; j < arr.length; j++){
                    if (arr[j] > max){
                        max = arr[j];
                    }
                }
                arr[i] = max;
                max = -1;
            }
            return arr;
        }
    }

    //逆序遍历
    public static int[] replaceElements2(int[] arr) {
        int[] result = new int[arr.length];
        int max = -1;
        result[arr.length - 1] = -1;
        for(int i = arr.length - 2; i >= 0; i--)
        {
            if(arr[i + 1] > max)
            {
                max = arr[i + 1];
            }
            result[i] = max;
        }
        return result;
    }

}
