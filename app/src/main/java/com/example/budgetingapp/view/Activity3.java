package com.example.budgetingapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.budgetingapp.R;

public class Activity3 extends AppCompatActivity {

    // TODO: (@Front-End) Fix activity so transactions can actually be stored

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        // Log.d("current amount", ((TextView) findViewById(R.id.moneyAmount)).getText().toString());
        getSupportActionBar().hide();
        Button removeButton = (Button) findViewById(R.id.doneButton);
        removeButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Activity3.this, Activity4.class));
            }
        });

        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Activity3.this, Activity2.class));
            }
        });
    }

    // TODO: (@Front-End) Revise method.
    public void addNum(View v) {
        String amount = ((TextView) findViewById(R.id.moneyAmount)).getText().toString();
        // double amount_double = Double.parseDouble(amount.substring(1));
        String num = ((Button) v).getText().toString();
        // Log.d("number value", num);

        if(amount.charAt(1) == '0') {
            String newStr = "$" +
                    amount.charAt(3) +
                    '.' +
                    amount.charAt(4) +
                    num;
            ((TextView) findViewById(R.id.moneyAmount)).setText(newStr);
        } else {
            String newStr = '$' +
                    amount.substring(1, amount.indexOf('.')) +
                    amount.charAt(amount.indexOf('.') + 1) +
                    '.' +
                    amount.charAt(amount.length() - 1) +
                    num;
            ((TextView) findViewById(R.id.moneyAmount)).setText(newStr);
        }
    }

}