package com.example.leeeh.pizzaapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView total;
    private int dough = 0;
    private int topping = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        total = (TextView)findViewById(R.id.textView4);
    }

    public void doughClick(View view){
        boolean check = ((RadioButton) view).isChecked();
//        Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_SHORT).show();
        switch(view.getId()) {
            case R.id.radioButton:
                if(check){
                    dough = 10000;
                    total.setText(String.valueOf(topping + dough));
                }
                break;
            case R.id.radioButton2:
                if(check){
                    dough = 15000;
                    total.setText(String.valueOf(topping + dough));
                }
                break;
            case R.id.radioButton3:
                if(check){
                    dough = 13000;
                    total.setText(String.valueOf(topping + dough));
                }
                break;
        }
    }
    public void toppingCick(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.checkBox:
                if(checked){
                    topping = topping + 3000;
                }
                else
                    topping = topping - 3000;
                total.setText(String.valueOf(topping + dough));
                break;

            case R.id.checkBox2:
                if(checked){
                    topping = topping + 2000;
                }
                else
                    topping = topping - 2000;
                total.setText(String.valueOf(topping + dough));
                break;
            case R.id.checkBox3:
                if(checked){
                    topping = topping + 4000;
                }
                else
                    topping = topping - 4000;
                total.setText(String.valueOf(topping + dough));
                break;
        }
    }
}
