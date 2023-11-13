package com.example.asphalt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class Calculator extends AppCompatActivity {

    private EditText number1, number2;
    private TextView result;
    private Button add, subtract, multiply, divide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        result = findViewById(R.id.textViewResult);
        add = findViewById(R.id.add);
        subtract = findViewById(R.id.sub);
        multiply = findViewById(R.id.mul);
        divide = findViewById(R.id.div);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("+");
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("-");
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("*");
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("/");
            }
        });
    }

    private void calculate(String operator) {
        try {
            double num1 = Double.parseDouble(number1.getText().toString());
            double num2 = Double.parseDouble(number2.getText().toString());
            double resultValue = 0;

            switch (operator) {
                case "+":
                    resultValue = num1 + num2;
                    break;
                case "-":
                    resultValue = num1 - num2;
                    break;
                case "*":
                    resultValue = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        resultValue = num1 / num2;
                    } else {
                        result.setText("Division by zero is not allowed");
                        return;
                    }
                    break;
            }

            result.setText("Result: " + resultValue);
        } catch (NumberFormatException e) {
            result.setText("Invalid input. Please enter valid numbers.");
        }
    }
}