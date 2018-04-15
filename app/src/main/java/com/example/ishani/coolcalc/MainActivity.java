package com.example.ishani.coolcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView resultView;

    //for operations
    public enum Operation{
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL;
    }

    String runningNumber="";
    String leftValueStr="";
    String rightValueStr="";
    Operation currentOperation;
    int result=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt1= (Button) findViewById(R.id.button1);
        Button bt2= (Button) findViewById(R.id.button2);
        Button bt3= (Button) findViewById(R.id.button3);
        Button bt4= (Button) findViewById(R.id.button4);
        Button bt5= (Button) findViewById(R.id.button5);
        Button bt6= (Button) findViewById(R.id.button6);
        Button bt7= (Button) findViewById(R.id.button7);
        Button bt8= (Button) findViewById(R.id.button8);
        Button bt9= (Button) findViewById(R.id.button9);
        Button bt0= (Button) findViewById(R.id.button0);

        ImageButton calcBtn= (ImageButton) findViewById(R.id.calcBtn);
        ImageButton addBtn= (ImageButton) findViewById(R.id.imageButtonadd);
        ImageButton subBtn= (ImageButton) findViewById(R.id.imageButtonsub);
        ImageButton divBtn= (ImageButton) findViewById(R.id.imageButtondiv);
        ImageButton mulBtn= (ImageButton) findViewById(R.id.imageButtonmul);

        Button clrBtn= (Button) findViewById(R.id.clrBtn);
        resultView= (TextView) findViewById(R.id.resultext);
        resultView.setText("");

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(1);

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(2);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(3);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(4);
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(5);
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(6);
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(7);
            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(8);
            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(9);
            }
        });

        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(0);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.ADD);

            }
        });

        mulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.MULTIPLY);
            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.SUBTRACT);

            }
        });

        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.DIVIDE);
            }
        });

        clrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rightValueStr= "";
                leftValueStr= "";
                result=0;
                runningNumber="";
                currentOperation= null;
                resultView.setText("0");

            }
        });

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.EQUAL);

                }
        });

    }

    void processOperation(Operation operation){
        if (currentOperation!=null){

            if(runningNumber!=""){
                rightValueStr=runningNumber;
                runningNumber="";

                switch (currentOperation){
                    case ADD:
                        result= Integer.parseInt(leftValueStr) + Integer.parseInt(rightValueStr);
                        break;
                    case SUBTRACT:
                        result= Integer.parseInt(leftValueStr) - Integer.parseInt(rightValueStr);
                        break;
                    case DIVIDE:
                        result= Integer.parseInt(leftValueStr) / Integer.parseInt(rightValueStr);
                        break;
                    case MULTIPLY:
                        result= Integer.parseInt(leftValueStr) * Integer.parseInt(rightValueStr);
                        break;
                }
                leftValueStr= String.valueOf(result);
                resultView.setText(leftValueStr);
            }
        }else{
            leftValueStr=runningNumber;
            runningNumber="";
            }

        currentOperation=operation;
    }

    void numberPressed(int number) {
        runningNumber += String.valueOf(number);
        resultView.setText(runningNumber);
    }
}
