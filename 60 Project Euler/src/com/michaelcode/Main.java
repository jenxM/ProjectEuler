package com.michaelcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        Primes primeObj = new Primes();

        primeObj.createArray();

        boolean[] primeArr = primeObj.getPrimeArray();

        PairSets obj = new PairSets(primeArr);

        obj.createPairList();

        obj.createSetLoop();
    }
}
