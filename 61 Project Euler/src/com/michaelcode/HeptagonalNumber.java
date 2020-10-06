package com.michaelcode;

import java.util.ArrayList;
import java.util.List;

public class HeptagonalNumber implements FigurateNumbers {

    List<ArrayList> heptNum2d = new ArrayList<>();

    public HeptagonalNumber(){
        loopToCreateNum();
    }

    @Override
    public List<ArrayList> getList() {
        return this.heptNum2d;
    }

    // formula for creating heptagonal number.
    @Override
    public int createNumberFormula(int n) {
        return (n * (5 * n - 3)) / 2;
    }

    // loop to get the number n for creating figurate number.
    @Override
    public void loopToCreateNum() {

        for(int i = 1; i < 65; i++){

            int heptNum = createNumberFormula(i);

            if(heptNum >= 1000 && heptNum < 10000) addNumberToList(heptNum);
        }

    }

    // adds number to a list, then a list of lists.

    @Override
    public void addNumberToList(int heptNum) {

        // creates string out of int.
        String num = String.valueOf(heptNum);

        // splits string.
        String part1 = num.substring(0, 2);

        String part2 = num.substring(2);

        // creates new list.
        ArrayList<String> heptSubList = new ArrayList<>();

        heptSubList.add(part1);

        heptSubList.add(part2);

        // adds list to 2d list.
        heptNum2d.add(heptSubList);

    }
}
