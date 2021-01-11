package com.lgf.jzoffer.chapterFour;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class Q29 {

    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0){
            return new int [0];
        }
        int d = 0 , a = 0;
        int b = matrix[0].length-1, c = matrix.length-1;

        int [] res = new int[(b+1)*(c+1)];
        int index = 0;
        while (true){
            for(int i=d;i<=b;i++){
                res[index] = matrix[a][i];
                index++;
            }
            a++;
            if(a > c) break;
            for(int i=a;i<=c;i++){
                res[index] = matrix[i][b];
                index++;
            }
            b--;
            if(b < d) break;
            for(int i=b;i>=d;i--){
                res[index] = matrix[c][i];
                index++;
            }
            c--;
            if(c < a) break;
            for(int i=c;i>=a;i--){
                res[index] = matrix[i][d];
                index++;
            }
            d++;
            if(d > b) break;
        }
        return res;
    }
}
