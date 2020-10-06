package com.michaelcode;


// interface for the polygonal number classes to use.

import java.util.ArrayList;
import java.util.List;

public interface FigurateNumbers {

    int createNumberFormula(int n);

    void loopToCreateNum();

    void addNumberToList(int num);

    List<ArrayList> getList();

}
