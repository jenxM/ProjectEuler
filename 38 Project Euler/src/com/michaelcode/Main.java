package com.michaelcode;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        for(int i = 2; i <= 100000; i++){
            PandigitalMultiple answer = new PandigitalMultiple();

            answer.createProducts(i);

            ArrayList<Integer> product = answer.getProductList();

            if(product.size() == 9) {

                boolean isPandigital = answer.checkPandigital();

                if(isPandigital){
                    System.out.println(answer.getOriginalList() + " " + i);
                }
            }
        }

    }
}

class PandigitalMultiple{

    ArrayList<Integer> productList = new ArrayList<>();
    ArrayList<Integer> originalList;

    public PandigitalMultiple(){

    }

    public ArrayList<Integer> getProductList(){
        return this.productList;
    }

    public ArrayList<Integer> getOriginalList(){
        return this.originalList;
    }

    public boolean checkPandigital(){

        this.originalList = new ArrayList<>(productList);

        for(int i = 1; i <= 9; i++){
            for(int j = 0; j < productList.size(); j++){

                int index = productList.get(j);

                if(index == i){
                    productList.remove(j);
                    break;
                }
            }
        }

        return productList.size() == 0;
    }

    public void numberToArray(int n){

        ArrayList<Integer> tempList = new ArrayList<>();

        while(n > 0){

            int digit = n % 10;

            tempList.add(digit);

            n = n / 10;

        }

        for(int i = tempList.size() - 1; i >= 0; i--){
            int index = tempList.get(i);

            productList.add(index);

        }
    }

    public void createProducts(int n){

        int index = 1;

        while(productList.size() < 9){

            int product = n * index;

            numberToArray(product);

            index++;

        }
    }
}