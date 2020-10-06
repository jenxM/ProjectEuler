package com.michaelcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class PairSets {

    boolean[] primeArray;

    HashSet<String> primePairs = new HashSet<>();

    public PairSets(boolean[] arr) {
        this.primeArray = arr;
    }

    public void createPairList(){

        int maxPrime = 9000;

        for(int i = 0; i < maxPrime; i++){
            for(int j = 0; j < maxPrime; j++){

                if(i != j && primeArray[i] && primeArray[j]){

                    String s = concatInteger(i, j);

                    boolean isPrime = Primes.checkPrime(s);

                    if(isPrime) primePairs.add(String.valueOf(i)); primePairs.add(String.valueOf(j));
                }
            }
        }

    }

    public ArrayList<String> sortList(ArrayList<String> list){

        ArrayList<Integer> n = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){
            n.add(Integer.parseInt(list.get(i)));
        }

        Collections.sort(n);

        ArrayList<String> s = new ArrayList<>();

        for(int i = 0; i < n.size(); i++){
            s.add(String.valueOf(n.get(i)));
        }

        return  s;
    }


    public boolean isTotalPrimeSet(ArrayList<String> list){

        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.size(); j++){

                if(i != j){

                    String s = concatenateString(list.get(i), list.get(j));

                    boolean isPrime = Primes.checkPrime(s);

                    if(!isPrime) return false;
                }
            }
        }

        return true;
    }

    public String concatenateString(String a, String b){
        return a + b;
    }

    public String concatInteger(int a, int b){

        return String.valueOf(a) + String.valueOf(b);
    }

    // original loop to find prime pair set.
    public void createSetLoop(){

        ArrayList<String> n = new ArrayList<>(primePairs);

        ArrayList<String> pNumPairs = sortList(n);

        for(int a = 5; a < pNumPairs.size(); a++){
            for(int b = 650; b < pNumPairs.size(); b++){
                for(int c = b + 1; c < pNumPairs.size(); c++){
                    for(int d = c + 1; d < pNumPairs.size(); d++){
                        for(int e = d + 1; e < pNumPairs.size(); e++){

                            ArrayList<String> ansList = new ArrayList<>();

                            ansList.add(pNumPairs.get(a));
                            ansList.add(pNumPairs.get(b));
                            ansList.add(pNumPairs.get(c));
                            ansList.add(pNumPairs.get(d));
                            ansList.add(pNumPairs.get(e));

                            boolean isAns = isTotalPrimeSet(ansList);

                            if(isAns) System.out.println(ansList);
                        }
                    }
                }
            }
        }
    }
}
