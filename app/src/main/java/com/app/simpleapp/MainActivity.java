package com.app.simpleapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity {

    private TextView calculator;
    private TextView number_hilt1, number_hilt2;
    private Button addition, subtraction, division, multiplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


            calculator = findViewById(R.id.calculator);
            number_hilt1 = findViewById(R.id.number_hilt1);
            number_hilt2 = findViewById(R.id.number_hilt2);
            addition = findViewById(R.id.addition);
            subtraction = findViewById(R.id.subtraction);
            division = findViewById(R.id.division);
            multiplication= findViewById(R.id.multiplication);


            addition.setOnClickListener(v-> calculate("+"));
            subtraction.setOnClickListener(v-> calculate("-"));
            division.setOnClickListener(v-> calculate("/"));
            multiplication.setOnClickListener(v-> calculate("*"));


    }

    private void calculate(String operation) {
        String input1 = number_hilt1.getText().toString().trim();
        String input2 = number_hilt2.getText().toString().trim();

        if (input1.isEmpty() || input2.isEmpty()) {
            calculator.setText("Enter both values");
            return;
        }
        try {

            float num1 = Float.parseFloat(input1);
            float num2 = Float.parseFloat(input2);
            float res = 0;

            switch (operation) {
                case "+":
                    res = num1 + num2;
                    break;
                case "-":
                    res = num1 - num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        calculator.setText("Division by zero");
                        return;
                    }
                    res = num1 / num2;
                    break;
                case "*":
                    res = num1 * num2;
                    break;
            }
            calculator.setText(String.valueOf(res));
        } catch (NumberFormatException e) {
            calculator.setText("Error enter");
        }
    }}