package com.example.budgetingapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.budgetingapp.R;
import com.example.budgetingapp.viewmodel.ApplicationViewModel;

public class Activity4 extends AppCompatActivity {

    ApplicationViewModel viewModel = new ApplicationViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4);
        getSupportActionBar().hide();
        /*Button doneButton = (Button) findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener(){
            // TODO: Establish functionality to add transaction to list
            public void onClick(View v){
                startActivity(new Intent(Activity4.this, MainActivity.class));
            }
        }); */

        ImageButton backButton = (ImageButton) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Activity4.this, Activity2.class));
            }
        });
    }
}