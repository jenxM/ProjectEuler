package com.michaelcode;

import java.util.ArrayList;
import java.util.List;

public class HexagonalNumber implements FigurateNumbers {

    List<ArrayList> hexNum2d = new ArrayList<>();

    public HexagonalNumber(){
        loopToCreateNum();
    }

    @Override
    public List<ArrayList> getList() {
        return this.hexNum2d;
    }

    @Override
    public int createNumberFormula(int n) {
        return (n * (2 * n - 1));
    }

    @Override
    public void loopToCreateNum() {

        for(int i = 1; i < 75; i++){

            int hexNum = createNumberFormula(i);

            if(hexNum >= 1000 && hexNum < 10000) addNumberToList(hexNum);
        }
    }

    @Override
    public void addNumberToList(int hexNum) {

        // creates string out of int.
        String num = String.valueOf(hexNum);

        // splits string.
        String part1 = num.substring(0, 2);

        String part2 = num.substring(2);

        // creates new list.
        ArrayList<String> hexSubList = new ArrayList<>();

        hexSubList.add(part1);

        hexSubList.add(part2);

        // adds list to 2d list.
        hexNum2d.add(hexSubList);

    }
}
