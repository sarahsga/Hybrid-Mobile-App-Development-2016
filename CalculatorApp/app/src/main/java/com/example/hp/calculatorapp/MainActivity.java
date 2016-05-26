package com.example.hp.calculatorapp;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    Button[] opArray;
    TextView calc_screen;
    TextView calc_small_screen;
    String op = null;
    Boolean isOpChosen = false;
    float number = -1;
    Boolean isEqualPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calc_screen = (TextView) findViewById(R.id.textView_result);
        calc_small_screen = (TextView) findViewById(R.id.textView_small);

        opArray = new Button[4];
        opArray[0] = (Button)findViewById(R.id.btn_add);
        opArray[1] = (Button)findViewById(R.id.btn_subtract);
        opArray[2] = (Button)findViewById(R.id.btn_multiply);
        opArray[3] = (Button)findViewById(R.id.btn_divide);
    }

    public void handleBtnClick(View view) {
        Button btn = (Button)view;
        int id = btn.getId();
        String text = (String) btn.getText();

        if ( isEqualPressed == true) {
            isEqualPressed = false;
            appendSmallText("AC");
        }

        switch (text) {
            case "AC":
                op = null;
                isOpChosen = false;
                calc_screen.setText("");
                changeOpColor(0);
                appendSmallText(text);
                break;
            case "=":

                isEqualPressed = true;
                calcResult();
                break;
            case "+":
            case "-":
            case "x":
            case "/":
                changeOpColor(id);
                opPressed((String)btn.getText());
                break;
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                appendSmallText(text);
                if (isOpChosen == true) {
                    isOpChosen = false;
                    changeOpColor(0);
                    number = Float.parseFloat((String)calc_screen.getText());
                    calc_screen.setText("");
                }
                calc_screen.setText(calc_screen.getText() + text);
                break;
        }
    }

    private void changeOpColor(int id) {

        for (int i = 0 ; i < opArray.length ; i++) {
            if (opArray[i].getId() == id) opArray[i].setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            else opArray[i].setBackgroundColor(getResources().getColor(R.color.color_ops));
        }
    }

    private void opPressed(String opArg) {
        if (isOpChosen == false) {
            appendSmallText(" " + opArg + " ");
            isOpChosen = true;
        }

        calcResult();

        op = opArg;
    }

    private void calcResult() {

        if (op != null) {
            float result = 0;
            switch(op) {
                case "+":
                    result = number + Float.parseFloat((String)calc_screen.getText());
                    break;
                case "-":
                    result = number - Float.parseFloat((String)calc_screen.getText());
                    break;
                case "x":
                    result = number * Float.parseFloat((String)calc_screen.getText());
                    break;
                case "/":
                    result = number / Float.parseFloat((String)calc_screen.getText());
                    break;
            }

            float difference = result - (int)result;
            if (difference == 0) {
                calc_screen.setText(Integer.toString((int)result));
            } else {
                calc_screen.setText(Float.toString(result));
            }
        }
    }


    private void appendSmallText(String textArg) {
        if (textArg.equals("AC")) {
            calc_small_screen.setText("");
        }
        else if (textArg.equals("=")) {}
        else {
            calc_small_screen.setText((String)calc_small_screen.getText() + textArg);
        }
    }
}
