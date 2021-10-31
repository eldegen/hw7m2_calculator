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

    private int isFirstClickOnSecondVar;

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

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_divide:
                isDivide = true;
                saveValueFromDisplay();
                isSecondVar = true;
                break;
            case R.id.btn_multiply:
                isMultiply = true;
                saveValueFromDisplay();
                isSecondVar = true;
                break;
            case R.id.btn_minus:
                isMinus = true;
                saveValueFromDisplay();
                isSecondVar = true;
                break;
            case R.id.btn_plus:
                isPlus = true;
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

        }
    }

    public void onNumClick(View view) {
        Button b = (Button) view;
        String btnText = b.getText().toString();
        setNumOnDisplay(btnText);

        if (isSecondVar) {
            isFirstClickOnSecondVar++;
            setNumOnDisplay(btnText);
        }
    }

    public void setNumOnDisplay(String numInput) {
        if (tvDisplay.getText().toString().equals("0")) {
            tvDisplay.setText(numInput);
        } else {
            tvDisplay.append(numInput);
        }

        if (isSecondVar) {
            if (isFirstClickOnSecondVar < 2) {
                tvDisplay.setText(numInput);
            } else {
                tvDisplay.append(numInput);
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

    /*public void onEquals(View view) {
        switch (view.getId()) {
            case R.id.btn_equals:
                saveValueFromDisplay();
                if (isDivide) {
                    int v1 = Integer.parseInt(firstVar);
                    int v2 = Integer.parseInt(secondVar);
                    finalVar = v1 / v2;
                    tvDisplay.setText(finalVar);
                }
                break;
        }
    }*/
}