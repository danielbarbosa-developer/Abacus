 package com.example.abacus;

 import abstractions.IMathOperation;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.TextView;
 import android.widget.Toast;
 import androidx.appcompat.app.AppCompatActivity;
 import application.ApplicationRules;
 import services.AddOperations;
 import services.SubtractOperations;
 import android.text.TextUtils;

 import java.util.ArrayList;
 import java.util.HashMap;

 import net.objecthunter.exp4j.Expression;
 import net.objecthunter.exp4j.ExpressionBuilder;

 public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private TextView numberZero,
            numberOne,
            numberTwo,
            numberThree,
            numberFour,
            numberFive,
            numberSix,
            numberSeven,
            numberEight,
            numberNine,
            signal,
            point,
            equalButton,
            addButton,
            subtractButton,
            multiplicatioButton,
            divisionButton,
            clearButton;

    private TextView display;

    private ApplicationRules rules = new ApplicationRules();

    private String FirstNumber = "";
    private String SecondNumber = "";
    private String onDisplayText = "";
    private String lastButton = "";
    private Expression _expression;
    private ArrayList<String> operationsOnDisplay = new ArrayList<String>();

    private HashMap<String, IMathOperation> operationsResource = new HashMap<String, IMathOperation>();


    private void InitializeComponents(){
        numberZero = findViewById(R.id.numberZero);
        numberOne = findViewById(R.id.numberOne);
        numberTwo = findViewById(R.id.numberTwo);
        numberThree = findViewById(R.id.numberThree);
        numberFour = findViewById(R.id.numberFour);
        numberFive = findViewById(R.id.numberFive);
        numberSix = findViewById(R.id.numberSix);
        numberSeven = findViewById(R.id.numberSeven);
        numberEight = findViewById(R.id.numberEight);
        numberNine = findViewById(R.id.numberNine);
        signal = findViewById(R.id.signal);
        point = findViewById(R.id.point);
        display = findViewById(R.id.display);
        equalButton = findViewById(R.id.equalButton);
        addButton = findViewById(R.id.addButton);
        subtractButton = findViewById(R.id.subtractButton);
        multiplicatioButton = findViewById(R.id.multiplicationButton);
        divisionButton = findViewById(R.id.divisionButton);
        clearButton = findViewById(R.id.clearButton);

        operationsResource.put("+", new AddOperations());
        operationsResource.put("-", new SubtractOperations());
        operationsResource.put("*", new AddOperations());
        operationsResource.put("/", new AddOperations());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitializeComponents();

        numberZero.setOnClickListener(this);
        numberOne.setOnClickListener(this);
        numberTwo.setOnClickListener(this);
        numberThree.setOnClickListener(this);
        numberFour.setOnClickListener(this);
        numberFive.setOnClickListener(this);
        numberSix.setOnClickListener(this);
        numberSeven.setOnClickListener(this);
        numberEight.setOnClickListener(this);
        numberNine.setOnClickListener(this);
        point.setOnClickListener(this);
        addButton.setOnClickListener(this);
        subtractButton.setOnClickListener(this);
        multiplicatioButton.setOnClickListener(this);
        divisionButton.setOnClickListener(this);

        equalButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                try{
                    _expression = new ExpressionBuilder(display.getText().toString()).build();
                    double result = _expression.evaluate();
                    long longResult = (long) result;
                    if(result == (double)longResult){
                        display.setText((CharSequence) String.valueOf(longResult));
                        onDisplayText = String.valueOf(result);
                    }else{
                        display.setText((CharSequence) String.valueOf(result));
                        onDisplayText = String.valueOf(result);
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "You must to define a valid math expression", Toast.LENGTH_LONG).show();
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onDisplayText = "";
                display.setText("");
            }
        });


    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.numberZero:
                AddExpression("0");
                break;
            case R.id.numberOne:
                AddExpression("1");
                break;
            case R.id.numberTwo:
                AddExpression("2");
                break;
            case R.id.numberThree:
                AddExpression("3");
                break;
            case R.id.numberFour:
                AddExpression("4");
                break;
            case R.id.numberFive:
                AddExpression("5");
                break;
            case R.id.numberSix:
                AddExpression("6");
                break;
            case R.id.numberSeven:
                AddExpression("7");
                break;
            case R.id.numberEight:
                AddExpression("8");
                break;
            case R.id.numberNine:
                AddExpression("9");
                break;
            case R.id.point:
                AddExpression(".");
                break;
            case R.id.addButton:
                AddExpression("+");
                break;
            case R.id.subtractButton:
                AddExpression("-");
                break;
            case R.id.multiplicationButton:
                AddExpression("*");
                break;
            case R.id.divisionButton:
                AddExpression("/");
                break;
        }
    }

    public void AddExpression(String keyboardValue){
        if(!onDisplayText.isEmpty()){
            char lastChar = onDisplayText.charAt(onDisplayText.length() - 1);
            if((!rules.IsUsedButtonNumber(Character.toString(lastChar))) && (!rules.IsUsedButtonNumber(keyboardValue))){
                onDisplayText = onDisplayText.replaceFirst(".$", keyboardValue);

            }else{
                onDisplayText = onDisplayText + keyboardValue;
            }
        }else{
            onDisplayText = onDisplayText + keyboardValue;
        }
        display.setText(onDisplayText);
    }


}