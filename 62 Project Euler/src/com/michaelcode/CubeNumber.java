package com.michaelcode;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;

public class CubeNumber {


    static ArrayList<BigInteger> cubeN = new ArrayList<>();

    public CubeNumber(){

        createCubeNum();

    }

    public static ArrayList<BigInteger> getCubeN() {
        return cubeN;
    }

    // creates cube numbers and adds to an array list.
    public void createCubeNum(){

        for(int i = 0; i <= 10000; i++){

            BigInteger index = BigInteger.valueOf(i);

            BigInteger cube = index.multiply(index).multiply(index);

            cubeN.add(cube);
        }

    }
}
