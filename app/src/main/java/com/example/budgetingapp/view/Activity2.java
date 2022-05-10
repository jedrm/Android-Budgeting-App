package com.example.budgetingapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.budgetingapp.R;
import com.example.budgetingapp.viewmodel.ApplicationViewModel;

public class Activity2 extends AppCompatActivity {

    ApplicationViewModel viewModel = new ApplicationViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        getSupportActionBar().hide();
        ImageButton addButton = (ImageButton) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Activity2.this, Activity3.class));
            }
        });

        ImageButton removeButton = (ImageButton) findViewById(R.id.removeButton);
        removeButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Activity2.this, Activity4.class));
            }
        });

        ImageButton backButton = (ImageButton) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Activity2.this, MainActivity.class));
            }
        });

    }
}