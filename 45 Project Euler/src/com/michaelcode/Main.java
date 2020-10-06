package com.michaelcode;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        TPHnumber numObj = new TPHnumber();

        // creates 3 arrays of triangle, pentagon and hexagon numbers.
        numObj.createTriArray();

        numObj.createPentArray();

        numObj.createHexArray();

        // gets 3 arrays.
        BigInteger[] triangleArray = numObj.getTriangleArray();

        BigInteger[] pentagonArray = numObj.getPentagonArray();

        BigInteger[] hexagonArray = numObj.getHexagonArray();


        Solution solutionObj = new Solution(triangleArray, pentagonArray, hexagonArray);

        // start loop of triangle numbers.
        solutionObj.triNumLoop();

        BigInteger answer = solutionObj.getNextTriangleNumber();

        System.out.println(answer);

    }
}

class Solution{

    // 3 arrays holding tri, pent and hex numbers.
    BigInteger[] triangleArray;
    BigInteger[] pentagonArray;
    BigInteger[] hexagonArray;

    // variable that hold next triangle number (answer).
    BigInteger nextTriangleNumber;

    // constructor sets 3 arrays with types of numbers we need to solve.
    public Solution(BigInteger[] tri, BigInteger[] pen, BigInteger[] hex){
        this.triangleArray = tri;
        this.pentagonArray = pen;
        this.hexagonArray = hex;
    }

    // returns answer.
    public BigInteger getNextTriangleNumber(){
        return this.nextTriangleNumber;
    }


    // loops triangle numbers, passes number to pentagonal number.
    public void triNumLoop(){

        for(int i = 286; i < triangleArray.length; i++){

            BigInteger n = triangleArray[i];

            // if boolean true for tri, pent and hex numbers, pass value to next tri number(answer).
            boolean isTPHNumber = penNumLoop(n);

            if(isTPHNumber) this.nextTriangleNumber = triangleArray[i];
        }
    }

    // gets tri number, checks if pent number, if true passes to hex, if not returns false.
    public boolean penNumLoop(BigInteger n){

        for(int i = 165; i < pentagonArray.length; i++){

            BigInteger pentagonNumber = pentagonArray[i];

            if(pentagonNumber.compareTo(n) == 0){
                return  hexNumLoop(n);
            }

            if(pentagonNumber.compareTo(n) > 0) break;
        }

        return false;
    }

    // gets number from pent loop, if hex number returns true.
    public boolean hexNumLoop(BigInteger n){

        for(int i = 143; i < hexagonArray.length; i++){

            BigInteger hexagonNumber = hexagonArray[i];

            if(hexagonNumber.compareTo(n) == 0){
                return true;
            }

            if(hexagonNumber.compareTo(n) > 0) break;

        }

        return false;
    }
}

class TPHnumber{

    private BigInteger[] triangleArray = new BigInteger[100000 + 1];
    private BigInteger[] pentagonArray = new BigInteger[100000 + 1];
    private BigInteger[] hexagonArray = new BigInteger[100000 + 1];

    public TPHnumber(){

    }

    // getters.
    public BigInteger[] getTriangleArray(){
        return this.triangleArray;
    }

    public BigInteger[] getPentagonArray(){
        return this.pentagonArray;
    }

    public BigInteger[] getHexagonArray(){
        return this.hexagonArray;
    }

    // loop and equations that save tri, pent and hex numbers to corresponding arrays.
    public void createTriArray(){

        // triangle number equation.
        for(int i = 0; i < triangleArray.length; i++){

            BigInteger index = BigInteger.valueOf(i);

            BigInteger triNumber = index.add(BigInteger.ONE).multiply(index);

            triNumber = triNumber.divide(BigInteger.TWO);

            this.triangleArray[i] = triNumber;
        }
    }

    public void createPentArray(){

        // pentagon number equation.
        for(int i = 0; i < pentagonArray.length; i++){

            BigInteger index = BigInteger.valueOf(i);

            BigInteger pentagonNumber = BigInteger.valueOf(3).multiply(index).subtract(BigInteger.ONE);

            pentagonNumber = pentagonNumber.multiply(index);

            pentagonNumber = pentagonNumber.divide(BigInteger.TWO);

            this.pentagonArray[i] = pentagonNumber;
        }
    }

    public void createHexArray(){

        // hexagon number equation.
        for(int i = 0; i < hexagonArray.length; i++){

            BigInteger index = BigInteger.valueOf(i);

            BigInteger hexagonalNumber = index.multiply(BigInteger.TWO).subtract(BigInteger.ONE);

            hexagonalNumber = hexagonalNumber.multiply(index);

            this.hexagonArray[i] = hexagonalNumber;
        }

    }

}