package com.michaelcode;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[100000];
        int index = 0;

        for(int i = 1; i < arr.length; i++){
            int b = divisor(i);
            if(divisor(b) == i && i != b){
                arr[index] = i;
                index++;
            }
        }


        int inputNumber = 10000;

        int totalSum = 0;

        for(int i = 0; i <= arr.length - 1; i++){
            if(arr[i] <= inputNumber){
                    totalSum += arr[i];
            }
        }

        System.out.println(totalSum);

    }

    public static int divisor(int n){
        int result = 0;
        int total = 1;

        for(int i = 2; i <= n; i++){
            if(n % i == 0){
                result = (n / i);
                if(result < i){break;}
                total += i + result;
            }
        }

        return total;

    }
}
