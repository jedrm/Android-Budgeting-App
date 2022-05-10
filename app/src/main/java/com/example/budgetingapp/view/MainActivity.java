package com.example.budgetingapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.budgetingapp.R;
import com.example.budgetingapp.viewmodel.ApplicationViewModel;

public class MainActivity extends AppCompatActivity {

    ApplicationViewModel viewModel = new ApplicationViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);
        getSupportActionBar().hide();
        Button expandButton = (Button) findViewById(R.id.expandButton);
        expandButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, Activity2.class));
            }
        });
    }
}