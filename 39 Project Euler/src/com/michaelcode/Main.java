package com.michaelcode;

public class Main {

    public static void main(String[] args) {

        IntegerRightTriangle answer = new IntegerRightTriangle();

        // iterates number that will be used as perimeters and pass to pythagorus.
        for(int i = 1; i <= 1000; i++){

            answer.loopDigits(i);
        }

        // gets array of combination counts;
        int[] arr = answer.getArrCounts();

        int maxSolutions = 0;
        int maxIndex = 0;

        // checks array for perimeters with largest number of combinations.
        for(int i = 0; i < arr.length; i++){

            int temp = arr[i];

            if(temp > maxSolutions){
                maxSolutions = temp;
                maxIndex = i;
            }
        }

        System.out.println(maxIndex);
    }
}

class IntegerRightTriangle{

    // array of counts.
    int[] arrCounts = new int[1000 + 1];

    public IntegerRightTriangle(){

    }

    // getters.
    public int[] getArrCounts(){
        return this.arrCounts;
    }

    // loops digits getting side a and side b of triangle, passes 3 sides to create array.
    public void loopDigits(int p){

        for(int i = 1; i <= p; i++){
            for(int j = i + 1; j <= p; j++){
                createArray(i, j, p);
            }
        }
    }

    // if formula is correct and equal to perimeter, number of counts for that perimeter is ++.
    public void createArray(int a, int b, int p){

        double c2 = (a * a) + (b * b);

        double c = Math.sqrt(c2);

        if(a + b + c == p){

            arrCounts[p]++;

        }
    }
}