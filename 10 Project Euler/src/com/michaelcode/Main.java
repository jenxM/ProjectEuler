package com.michaelcode;

public class Main {

    public static void main(String[] args) {
        int[] prime = new int[2000000 + 1];

        for(int i = 0; i <= 2000000; i++){
            prime[i] = 1;
        }

        prime[0] = 0;
        prime[1] = 0;

        for(int i = 2; i <= Math.sqrt(2000000); i++){
            if(prime[i] == 1){
                for(int j = 2; i * j <= 2000000; j++){
                    prime[i * j] = 0;
                }
            }
        }

        long[] sumArr = new long[2000000 + 1];

        sumArr[0] = 0;
        sumArr[1] = 0;

        for(int i = 2; i <= 2000000; i++){
            if(prime[i] == 1){
                sumArr[i] = sumArr[i - 1] + i;
            }else{
                sumArr[i] = sumArr[i - 1];
            }
        }

        int n = 2000000;
        System.out.println(sumArr[n]);
    }
}
