package com.michaelcode;

import java.util.ArrayList;
import java.util.List;


public class TriangleNumber implements FigurateNumbers {

    List<ArrayList> triList2d = new ArrayList<>();

    public TriangleNumber(){
        loopToCreateNum();
    }

    @Override
    public List<ArrayList> getList() {
        return this.triList2d;
    }

    // create tri number with tri num formula.

    @Override
    public int createNumberFormula(int n) {
        return (n * (n + 1)) / 2;
    }

    // loop to get N for formula.

    @Override
    public void loopToCreateNum() {

        for(int i = 1; i <= 145; i++){

            int triNum = createNumberFormula(i);

            if(triNum >= 1000 && triNum < 10000) addNumberToList(triNum);
        }

    }

    // takes in int from loop, converts to string and splits, adding list to 2d list.

    @Override
    public void addNumberToList(int triNum) {

        // creates string out of int.
        String num = String.valueOf(triNum);

        // splits string.
        String part1 = num.substring(0, 2);

        String part2 = num.substring(2);

        // creates new list.
        ArrayList<String> triSubList = new ArrayList<>();

        triSubList.add(part1);

        triSubList.add(part2);

        // adds list to 2d list.
        triList2d.add(triSubList);

    }

}
