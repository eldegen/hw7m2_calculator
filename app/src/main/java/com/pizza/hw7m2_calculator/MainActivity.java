package com.pizza.hw7m2_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnAC, btnPlusMinus, btnPercent, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDivide, btnMultiply, btnMinus, btnPlus, btnEquals, btnComma;
    private TextView tvDisplay;

    private boolean isSecondVar = false;
    private boolean isDivide = false;
    private boolean isMultiply = false;
    private boolean isMinus = false;
    private boolean isPlus = false;

    private double firstVar, secondVar;
    private double finalVar;

    private int isFirstClickOnSecondVar = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAC = findViewById(R.id.btn_ac);
        btnPlusMinus = findViewById(R.id.btn_plus_and_minus);
        btnPercent = findViewById(R.id.btn_percent);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btn0 = findViewById(R.id.btn_0);
        btnDivide = findViewById(R.id.btn_divide);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnMinus = findViewById(R.id.btn_minus);
        btnPlus = findViewById(R.id.btn_plus);
        btnEquals = findViewById(R.id.btn_equals);

        tvDisplay = findViewById(R.id.tv_display);

        btnDivide.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnAC.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_divide:
                isDivide = true;

                isMultiply = false;
                isMinus = false;
                isPlus = false;
                saveValueFromDisplay();
                isSecondVar = true;
                break;
            case R.id.btn_multiply:
                isMultiply = true;

                isDivide = false;
                isMinus = false;
                isPlus = false;
                saveValueFromDisplay();
                isSecondVar = true;
                break;
            case R.id.btn_minus:
                isMinus = true;

                isDivide = false;
                isMultiply = false;
                isPlus = false;
                saveValueFromDisplay();
                isSecondVar = true;
                break;
            case R.id.btn_plus:
                isPlus = true;

                isDivide = false;
                isMultiply = false;
                isMinus = false;
                saveValueFromDisplay();
                isSecondVar = true;
                break;
            case R.id.btn_equals:
                Toast.makeText(this, "bruh", Toast.LENGTH_SHORT).show();
                if (isDivide) {
                    saveValueFromDisplay();
                    finalVar = firstVar / secondVar;
                    String result = String.valueOf(finalVar);
                    tvDisplay.setText(result);
                }
                if (isMultiply) {
                    saveValueFromDisplay();
                    finalVar = firstVar * secondVar;
                    String result = String.valueOf(finalVar);
                    tvDisplay.setText(result);
                }
                if (isMinus) {
                    saveValueFromDisplay();
                    finalVar = firstVar - secondVar;
                    String result = String.valueOf(finalVar);
                    tvDisplay.setText(result);
                }
                if (isPlus) {
                    saveValueFromDisplay();
                    finalVar = firstVar + secondVar;
                    String result = String.valueOf(finalVar);
                    tvDisplay.setText(result);
                }
                break;
            case R.id.btn_ac:
                Toast.makeText(this, "furry", Toast.LENGTH_SHORT).show();
                clearAll();

        }
    }

    public void onNumClick(View view) {
        Button b = (Button) view;
        String btnText = b.getText().toString();
        setNumOnDisplay(btnText);

        if (isSecondVar) {
            isFirstClickOnSecondVar++;
            altSetNumOnDisplay(btnText);
        }
    }

    public void setNumOnDisplay(String numInput) {
        if (tvDisplay.getText().toString().equals("0")) {
            tvDisplay.setText(numInput);
        } else {
            tvDisplay.append(numInput);
        }
    }

    public void altSetNumOnDisplay(String numInput) {
        if (isSecondVar) {
            if (isFirstClickOnSecondVar <= 1) {
                tvDisplay.setText(numInput);
            } else {
//                tvDisplay.append(numInput);
            }
        }
    }

    public void saveValueFromDisplay() {
        if (!isSecondVar) {
            firstVar = Integer.parseInt(tvDisplay.getText().toString());
        } else {
            secondVar = Integer.parseInt(tvDisplay.getText().toString());
        }
    }

    public void clearAll() {
        isSecondVar = false;

        isDivide = false;
        isMultiply = false;
        isMinus = false;
        isPlus = false;

        firstVar = 0;
        secondVar = 0;
        finalVar = 0;
        isFirstClickOnSecondVar = 0;

        tvDisplay.setText("0");
    }
}