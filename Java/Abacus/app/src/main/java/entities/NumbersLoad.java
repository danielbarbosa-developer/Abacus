package entities;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class NumbersLoad {

    public NumbersLoad(int firstNumber, int secondNumber){
        this._firstNumber = firstNumber;
        this._secondNumber = secondNumber;
    }

    private int _firstNumber;

    private int _secondNumber;

    public int getFirstNumber(){
        return this._firstNumber;
    }

    public int getSecondNumber(){
        return this._secondNumber;
    }


}
