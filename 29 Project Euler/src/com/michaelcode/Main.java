package com.michaelcode;

import java.util.*;
import java.math.*;


public class Main {
    static int n = 100;
    static ArrayList<BigInteger> powersList = new ArrayList();

    public static void main(String[] args) {
            generatePowers();
            duplicateCheck();
            System.out.println(powersList.size());

    }

    public static void generatePowers(){
        for(int i = 2; i <= n; i++){
            for(int j = 2; j <= n; j++){
                BigInteger result = BigInteger.valueOf(i).pow(j);
                powersList.add(result);
            }
        }
    }

    public static void duplicateCheck(){
        for(int i = 0; i < powersList.size(); i++){
            for(int j = i+1 ; j < powersList.size(); j++){
                BigInteger indexI = powersList.get(i);
                BigInteger indexJ = powersList.get(j);
                if(indexI.compareTo(indexJ) == 0){
                    powersList.remove(j);
                }
            }
        }
    }
}
