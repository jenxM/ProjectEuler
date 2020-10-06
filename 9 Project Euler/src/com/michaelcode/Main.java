package com.michaelcode;

public class Main {

    public static void main(String[] args) {
        int n = 1000;

        int c = 0;
        long result = 0;
        long product = 0;

        for(int i = 2; i <= n; i++){
            for( int j = i; j <= n; j++){
                c = n - (i + j);
                if((i * i) + (j * j) == (c * c) && c > 0){
                    result = i * j * c;
                    if(result > product){
                        product = result;
                    }
                }
                if((i + j) > n){break;}
            }
        }

        if(product > 0){
            System.out.println(product);
        }else{
            System.out.println(-1);
        }
    }
}
