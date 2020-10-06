package com.michaelcode;


import java.math.BigInteger;
import java.util.*;

public class Solution {

    ArrayList<BigInteger> cube;

    public Solution(){
        cube = CubeNumber.getCubeN();
    }

    HashMap<BigInteger, Integer> permCheck = new HashMap<>();

    // creates map using cube numbers as keys.
    public void createMap() {

        for (int i = 0; i < cube.size(); i++) {

            BigInteger b = cube.get(i);

            permCheck.put(b, 0);
        }

    }

    // inputs big integer and sorts into string.
    public String sortCube(BigInteger b){

            char[] arr = String.valueOf(b).toCharArray();

            Arrays.sort(arr);

            String s = String.valueOf(arr);

            return s;
    }

    // iterates keys, converts to sorted string then compares, if equal increments value by 1.
    public void searchHashMap(String sorted){

        Iterator keySetIterator = permCheck.keySet().iterator();

        while (keySetIterator.hasNext())
        {
            BigInteger key = (BigInteger) keySetIterator.next();

            String mapKey = sortCube(key);

            if(mapKey.compareTo(sorted) == 0){

                permCheck.put(key, permCheck.get(key) + 1);
            }
        }
    }

    // uses cube to sort then checks if hash map has value.
    public void driverLoop(){

        for(int i = 0; i < cube.size(); i++){

            String s = sortCube(cube.get(i));

            searchHashMap(s);

            if(permCheck.containsValue(5)){
                findKey();
            }
        }
    }

    // finds key with smallest value of 5.
    public void findKey(){

        Integer value = 5;

        BigInteger smallest = new BigInteger("1000000000000000");

        Set<BigInteger> keys = permCheck.keySet();

        for (BigInteger key: keys
             ) {
            if(permCheck.get(key).equals(value)){
                if(key.compareTo(smallest) < 0){
                    smallest = key;
                }
            }
        }

        System.out.println(smallest);
    }
}
