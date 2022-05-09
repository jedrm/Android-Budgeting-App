package com.example.budgetingapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.budgetingapp.R;

public class Activity3 extends AppCompatActivity {

    // TODO: (@Front-End) Fix activity so transactions can actually be stored
    // TODO: (@Front-End) Allow user to input transaction name and cycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        // Log.d("current amount", ((TextView) findViewById(R.id.moneyAmount)).getText().toString());
        getSupportActionBar().hide();
        Button removeButton = (Button) findViewById(R.id.removeButton);
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

    public void addNum(View v) {

        String amount = ((TextView) findViewById(R.id.moneyAmount)).getText().toString();
        String num = ((Button) v).getText().toString();
        StringBuilder sb = new StringBuilder();

        sb.append('$');
        if(amount.charAt(1) != '0') sb.append(amount.substring(1, amount.indexOf('.')));
        sb.append(amount.charAt(amount.indexOf('.') + 1));
        sb.append('.');
        sb.append(amount.charAt(amount.length() - 1));
        sb.append(num);
        ((TextView) findViewById(R.id.moneyAmount)).setText(sb.toString());

    }

    public void removeNum(View v) {

        String amount = ((TextView) findViewById(R.id.moneyAmount)).getText().toString();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb_reverse = new StringBuilder();

        for(int i = amount.length() - 1; i >= 0; i--) sb_reverse.append(amount.charAt(i));

        sb.append(sb_reverse.charAt(1));
        sb.append(sb_reverse.charAt(3));
        sb.append('.');
        if(sb_reverse.charAt(4) == '$' && sb_reverse.charAt(3) != 0) sb.append("0$");
        else sb.append(sb_reverse.substring(4));

        sb.reverse();
        ((TextView) findViewById(R.id.moneyAmount)).setText(sb.toString());

    }

}