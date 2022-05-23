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
import com.example.budgetingapp.model.TransactionCount;
import com.example.budgetingapp.viewmodel.ApplicationViewModel;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ApplicationViewModel viewModel = new ApplicationViewModel();
    private List<Transaction> transactionList;
    private List<TransactionCount> transactionCounts;
    private listAdapter listAdapter;
    private PieChart chart;

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
        transactionCounts = viewModel.getAllCount(getApplicationContext());

        // TODO: Create an array of colors of different colors
        String[] colors = {
                "#bf84f0", "#f3d034", "#cd9fb1", "#cd9fb1",
                "#27703f", "#f0f672", "#2c6ae5", "#10c00a",
                "#27dd80", "#52312f", "#5bb2c5", "#eeb8d2",
                "#5c18d0", "#dc9232", "#440b10", "#cb4332",
                "#782984"
        };

        // TODO: Check if there is a summary of transaction counts
        if (transactionCounts.isEmpty()) {
            chart.startAnimation();
            return;
        }

        // TODO: Loop through the list of transaction counts
        int index = 0;
        for (TransactionCount transactionCount: transactionCounts) {
            chart.addPieSlice(new PieModel(
                    transactionCount.getTransactionType(),
                    transactionCount.getTypeCount(),
                    Color.parseColor(colors[index++])
            ));
        }

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