package services;

import abstractions.IMathOperation;
import entities.NumbersLoad;

import java.util.ArrayList;

public class AddOperations implements IMathOperation {

    private int _result = 0;

    @Override
    public int Calculate(NumbersLoad numbersVO) {
        _result = numbersVO.getFirstNumber() + numbersVO.getSecondNumber();
        return _result;
    }

    @Override
    public int Calculate(ArrayList<NumbersLoad> numbersList) {

        numbersList.forEach(number ->{
            _result = number.getFirstNumber() + number.getSecondNumber();
        });

        return _result;
    }
}
