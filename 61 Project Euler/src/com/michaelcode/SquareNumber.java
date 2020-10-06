package com.michaelcode;

import java.util.*;

public class SquareNumber implements FigurateNumbers {

    List<ArrayList> squareNum2d = new ArrayList<>();

    public SquareNumber(){
        loopToCreateNum();
    }

    @Override
    public List<ArrayList> getList() {
        return this.squareNum2d;
    }

    // formula for creating square number;
    @Override
    public int createNumberFormula(int n) {
        return n * n;
    }

    @Override
    public void loopToCreateNum() {

        for(int i = 1; i < 105; i++){

            int squareNum = createNumberFormula(i);

            if(squareNum >= 1000 && squareNum < 10000) addNumberToList(squareNum);
        }
    }

    @Override
    public void addNumberToList(int squareNum) {

        // creates string out of int.
        String num = String.valueOf(squareNum);

        // splits string.
        String part1 = num.substring(0, 2);

        String part2 = num.substring(2);

        // creates new list.
        ArrayList<String> squareSubList = new ArrayList<>();

        squareSubList.add(part1);

        squareSubList.add(part2);

        // adds list to 2d list.
        squareNum2d.add(squareSubList);

    }


}
