package com.michaelcode;

import java.util.ArrayList;
import java.util.List;

public class OctagonalNumber implements FigurateNumbers{

    List<ArrayList> octNum2d = new ArrayList<>();

    public OctagonalNumber(){
        loopToCreateNum();
    }

    @Override
    public List<ArrayList> getList() {
        return this.octNum2d;
    }

    @Override
    public int createNumberFormula(int n) {
        return (n * (3 * n - 2));
    }

    @Override
    public void loopToCreateNum() {

        for(int i = 1; i < 60; i++){

            int octNum = createNumberFormula(i);

            if(octNum >= 1000 && octNum < 10000) addNumberToList(octNum);
        }
    }

    @Override
    public void addNumberToList(int octNum) {

        // creates string out of int.
        String num = String.valueOf(octNum);

        // splits string.
        String part1 = num.substring(0, 2);

        String part2 = num.substring(2);

        // creates new list.
        ArrayList<String> octSubList = new ArrayList<>();

        octSubList.add(part1);

        octSubList.add(part2);

        // adds list to 2d list.
        octNum2d.add(octSubList);

    }
}
