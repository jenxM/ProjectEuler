package com.michaelcode;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        Prime primeObj = new Prime();

        primeObj.createPrimeArray();

        boolean[] primeArr = primeObj.getPrimeArray();

        for(int i = 1000; i < 10000; i++){

            if(primeArr[i]){

                Permutations permutationObj = new Permutations();

                permutationObj.setPrimeArray(primeArr);

                String s = String.valueOf(i);

                String[] number = s.split("");

                permutationObj.heapsAlgo(number, 4 , 4);

                permutationObj.deleteComposites();

                ArrayList<Integer> primePermutations = permutationObj.getPrimeSeries();

                Series seriesObj = new Series();

                seriesObj.setPrimeList(primePermutations);

                seriesObj.sortList();

                seriesObj.checkSeries();
            }
        }

    }
}

class Series{

    ArrayList<Integer> primeList = new ArrayList<>();


    public Series(){

    }

    public void setPrimeList(ArrayList<Integer> list){
        this.primeList = list;
    }

    public void checkSeries(){

        for(int i = 0; i < primeList.size() - 1; i++){
            for(int j = i + 1; j < primeList.size(); j++){

                int indexI = primeList.get(i);
                int indexJ = primeList.get(j);
                int difference = indexJ - indexI;

                int nextPrime = indexJ + difference;

                boolean isAnswer = checkPrime(nextPrime);

                if(isAnswer){
                    if(indexI != indexJ && indexJ != nextPrime){
                        System.out.println(indexI + " " + indexJ + " " + nextPrime);
                    }
                }
            }
        }
    }

    public boolean checkPrime(int n){

        for(int i = 0; i < primeList.size(); i++){
            int temp = primeList.get(i);
            if(n == temp) return true;
        }

        return false;
    }


    public void sortList(){

        for(int i = 0; i < primeList.size() - 1; i++){
            for(int j = i + 1; j < primeList.size(); j++){

                int indexI = primeList.get(i);
                int indexJ = primeList.get(j);

                if(indexI > indexJ){
                    int temp = indexI;
                    primeList.set(i, indexJ);
                    primeList.set(j, temp);
                }
            }
        }
    }
}

class Permutations{

    boolean[] primeArray;

    ArrayList<String> primePermutations = new ArrayList<>();

    ArrayList<Integer> primeSeries = new ArrayList<>();

    public Permutations(){

    }

    public void setPrimeArray(boolean[] arr){
        this.primeArray = arr;
    }



    public ArrayList<Integer> getPrimeSeries(){
        return this.primeSeries;
    }

    public void deleteComposites(){

        for(int i = 0; i < primePermutations.size(); i++){

            String temp = primePermutations.get(i);

            int number = Integer.parseInt(temp);

            if(primeArray[number]) primeSeries.add(number);
        }

    }

    public void createPermutationList(String[] arr){

        String number = arr[0] + arr[1] + arr[2] + arr[3];

        this.primePermutations.add(number);

    }

    public void heapsAlgo(String[] arr, int size, int n){

        if(size == 1) createPermutationList(arr);

        for(int i = 0; i < size; i++){

            heapsAlgo(arr, size - 1, n);

            if(size % 2 == 1){

                String temp = arr[0];

                arr[0] = arr[size - 1];

                arr[size - 1] = temp;
            }
            else{

                String temp = arr[i];

                arr[i] = arr[size - 1];

                arr[size - 1] = temp;
            }

        }
    }

}

class Prime{

    private static boolean[] primeArray = new boolean[10000];

    public Prime(){

    }

    public boolean[] getPrimeArray(){
        return primeArray;
    }

    public void createPrimeArray(){

        for(int i = 2; i < primeArray.length; i++){
            primeArray[i] = true;
        }

        for(int p = 2; p < primeArray.length; p++){

            if(primeArray[p]){

                for(int i = p * 2; i < primeArray.length; i += p){

                    primeArray[i] = false;

                }
            }
        }
    }
}