package abstractions;

import entities.NumbersLoad;

import java.util.ArrayList;

public interface IMathOperation {

    int Calculate(NumbersLoad numbersVO);

    int Calculate(ArrayList<NumbersLoad> numbersList);
}
