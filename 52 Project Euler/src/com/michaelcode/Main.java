package com.michaelcode;

import java.util.ArrayList;
import java.util.HashSet;


public class Main {

    public static void main(String[] args) {

        // driver loop, i is starting number.
        for(long i = 1000; i < 1000000; i++){

            DigitToList orignalObj = new DigitToList();

            // converts i to a list.
            ArrayList<Long> number = orignalObj.digitList(i);

            // if list is empty, number contained duplicates.
            if(!number.isEmpty()){

                Permutation permutationObj = new Permutation();

                // creates permutations of number.
                permutationObj.heapsAlgo(number, number.size());

                // list of lists permutation.
                ArrayList<ArrayList<Long>> leaderList = permutationObj.getLeaderList();

                Multiples answerObj = new Multiples();

                answerObj.setLeaderList(leaderList);

                // calls recursive method to check multiples.
                boolean isPermutationMultiple = answerObj.checkMulitples(i, 2, i);

                // returns true if answer.
                if(isPermutationMultiple) System.out.println(i);
            }
        }

    }
}

// class takes in a number and converts to list.
class DigitToList{

    public DigitToList(){

    }

    // input a number and converts to list, also converts to a set and compares sizes for duplicate check.
    public ArrayList<Long> digitList(long n){

        HashSet<Long> a = new HashSet<>();
        ArrayList<Long> b = new ArrayList<>();

        // loop creates list and set.
        while(n > 0){

            long digit = n % 10;

            a.add(digit);
            b.add(0, digit);

            n = n / 10;
        }

        if(a.size() == b.size()) return b;

        b.clear();

        return b;

    }

}

// creates multiples of number and checks permutations.
class Multiples{

    // list of lists each a permutation.
    ArrayList<ArrayList<Long>> leaderList;


    public  Multiples(){

    }


    public void setLeaderList(ArrayList<ArrayList<Long>> leaderList) {
        this.leaderList = leaderList;
    }

    // recursive method checking lists of permutation.
    public boolean checkMulitples(long originalNumber, int n, long product){

        // base case, if n > 6, number must be answer.
        if(n > 6) return true;

        // checks number is in permutations.
        boolean containsNumber = checkList(product);

        // if true, number gets multiplied by n and called again recursively.
        if(containsNumber){
            n = n + 1;
            product = originalNumber * n;
            return checkMulitples(originalNumber, n, product);
        }

        // return false if number is not in permutations.
        return false;
    }

    // checks if array list is equal to a number.
    // number is a string, loop turns array list into a string.
    public boolean checkList(long n){

        String number = String.valueOf(n);

        // outer loop gets each list from array of list.
        for(int i = 0; i < leaderList.size(); i++){

            ArrayList<Long> temp = new ArrayList<>(leaderList.get(i));

            StringBuilder sb = new StringBuilder();

            // inner loop gets list and converts into a string.
            for(int j = 0; j < temp.size(); j++){

                long num = temp.get(j);

                sb.append(num);
            }

            String result = sb.toString();

            // checks if number is equal to any of lists in array of lists.
            if(number.compareTo(result) == 0) return true;
        }

        return false;

    }
}


class Permutation{

    // creates a list of permutation lists.
    ArrayList<ArrayList<Long>> leaderList = new ArrayList<>();

    public Permutation(){

    }

    public ArrayList<ArrayList<Long>> getLeaderList(){
        return this.leaderList;
    }

    // creates permutation of digits using heaps algorithm.
    public void heapsAlgo(ArrayList<Long> list, int size ){

        if(size == 1){
            leaderList.add(new ArrayList<Long>(list));
        }

        for(int i = 0; i < size; i++){

            heapsAlgo(list, size - 1 );

            if(size % 2 == 1){

                long temp = list.get(0);

                long temp2 = list.get(size - 1);

                list.set(0, temp2);

                list.set(size - 1, temp);
            }
            else{

                long temp = list.get(i);

                long temp2 = list.get(size - 1);

                list.set(i, temp2);

                list.set(size - 1, temp);
            }
        }
    }
}