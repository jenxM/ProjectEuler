package com.michaelcode;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    static long maxNumber = 10000;
    static ArrayList<Long> digitList = new ArrayList<>();
    static long product;
    static long maxProduct;
    static ArrayList<Long> sumProducts = new ArrayList<>();

    public static void main(String[] args) {
    getDigits();
    sumSet();
    System.out.println(maxProduct);
    }

    public static void sumSet(){
        Set<Long>  sum = new LinkedHashSet<>(sumProducts);
        for (long i:sum
             )
            maxProduct += i;
    }


    public static void checkDuplicate(){
        int counter = 0;
       A: for(int i = 0; i < digitList.size() - 1; i++){
            for(int j = i + 1; j < digitList.size(); j++){
                long indexI = digitList.get(i);
                long indexJ = digitList.get(j);
                if(indexI == indexJ){
                    counter++;
                    break A;
                }
            }
        }
        if(counter == 0){
            sumProducts.add(product);

        }
    }

    public static void createList(long n){
        while (n > 0){
            long temp = n % 10;
            if(temp == 0){
                digitList.clear();
                break;
            }
            digitList.add(temp);
            n = n / 10;
        }

    }

    public static void getDigits(){
        for(long i = 1; i <= maxNumber; i++){
            for(long j = i; j <= maxNumber; j++){
                product = i * j;
                createList(product);
                createList(i);
                createList(j);
                if(digitList.size() == 9){
                    checkDuplicate();
                }

                digitList.clear();
            }
        }
    }
}
