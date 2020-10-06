package com.michaelcode;

import java.util.*;
import java.math.*;

public class Main {
    static ArrayList<BigInteger> fibNum = new ArrayList<BigInteger>();
    static HashMap<Integer, BigInteger> fibTerm = new HashMap<Integer, BigInteger>();

    public static void main(String[] args) {
        createList();
        listSearch(1000);
    }
    public static void listSearch(int n){
        BigInteger ceiling = BigInteger.TEN.pow(n);
        BigInteger floor = BigInteger.TEN.pow(n-1);

        for(Map.Entry<Integer, BigInteger> entry : fibTerm.entrySet()){
            BigInteger answer = entry.getValue();
            int keyAnswer = entry.getKey();
            if(answer.compareTo(ceiling) < 0 && answer.compareTo(floor) >= 0){
                System.out.println(keyAnswer);
            }
        }
    }
    public static void createList(){

        fibNum.add(0, BigInteger.ONE);
        fibNum.add(1, BigInteger.ONE);
        BigInteger index = BigInteger.ONE;
        for(int i = 2; i <= 5000; i++){
            BigInteger x = fibNum.get(i-1);
            BigInteger y = fibNum.get(i-2);
            BigInteger currentFib = x.add(y);
            fibNum.add(i, currentFib);
            if(currentFib.compareTo(index) > 0){
                fibTerm.put(i + 1, currentFib);
                index = index.multiply(BigInteger.TEN);
            }
        }
    }
}
