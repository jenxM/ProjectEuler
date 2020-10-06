package com.michaelcode;

public class Main {

    public static void main(String[] args) {
        long[] triNum = new long[10000000 + 1];
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41};
        long[] divNum = new long[10000000 + 1];

        long naturalNum = 0;

        for(int i = 0; i < triNum.length; i++){
            naturalNum = i + 1;
            triNum[i] = (naturalNum * (naturalNum + 1) / 2);

        }

        int j = 0;
        long count = 1;
        long product = 1;

        for(int i = 0; i < triNum.length; i++){
            long x = triNum[i];
            while(j < 13){
                int y = prime[j];
                if(x == 1){break;}
                if(x % y == 0){
                    x = x / y;
                    count++;
                }
                if(x % y != 0){
                    j++;
                    product = product * count;
                    count = 1;
                }

            }
            j = 0;
            divNum[i] = product;
            product = 1;
        }

        int n = 500;

        for(int i = 0; i < divNum.length; i++){
            long k = divNum[i];
            if(n < k){
                System.out.println(triNum[i]);
                break;
            }
        }
    }
}
