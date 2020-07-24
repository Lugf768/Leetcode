package com.lgf.array;

import java.rmi.activation.ActivationGroup;

public class average {

    public static void main(String[] args) {
        int[] a ={8000,9000,2000,3000,6000,1000};
        double i = average(a);
        System.out.println(i);
    }

    public static double average(int[] salary) {
        double avg = 0, min = salary[0], max = salary[0], sum= 0;
        for (int i = 0; i < salary.length; i++){
            sum = sum + salary[i];
            if (salary[i] > max){
                max = salary[i];
            }else if (salary[i] < min){
                min = salary[i];
            }
        }
        avg = (sum - max - min)/(salary.length -2);
        return avg;
    }
}
