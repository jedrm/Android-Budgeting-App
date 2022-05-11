package com.example.budgetingapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.budgetingapp.R;
import com.example.budgetingapp.model.Transaction;
import com.example.budgetingapp.viewmodel.ApplicationViewModel;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ApplicationViewModel viewModel = new ApplicationViewModel();
    private List<Transaction> transactionList;
    private listAdapter listAdapter;
    private PieChart chart;
    private int i1 = 15;
    private int i2 = 25;
    private int i3 = 35;
    private int i4 = 45;

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
        initRecyclerView();
        loadTransactions();

        chart = findViewById(R.id.pieChart);
        addToPieChart();
    }

    private void addToPieChart() {
        chart.addPieSlice(new PieModel("Item 1", i1, Color.parseColor("#b7aeff")));
        chart.addPieSlice(new PieModel("Item 2", i2, Color.parseColor("#de5460")));
        chart.addPieSlice(new PieModel("Item 3", i3, Color.parseColor("#06025e")));
        chart.addPieSlice(new PieModel("Item 4", i4, Color.parseColor("#65e1cf")));
        chart.startAnimation();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        listAdapter = new listAdapter(this);
        recyclerView.setAdapter(listAdapter);
    }


    private void loadTransactions() {
        transactionList = viewModel.getAllTransactions(this.getApplicationContext());
        listAdapter.setTransactionList(transactionList);
    }
}