package com.example.budgetingapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.budgetingapp.R;
import com.example.budgetingapp.model.Transaction;
import com.example.budgetingapp.viewmodel.ApplicationViewModel;

import java.util.List;

/**
 * Class containing functionality for activity 4.
 *
 * FEATURES:
 * - allows user to remove transactions with left/right swipes
 * - connects to activity 2
 */
public class Activity4 extends AppCompatActivity {

    ApplicationViewModel viewModel = new ApplicationViewModel();
    private List<Transaction> transactionList;
    private listAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4);
        getSupportActionBar().hide();

        // back button -> go back to activity 2
        ImageButton backButton = (ImageButton) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Activity4.this, Activity2.class));
            }
        });
        initRecyclerView();
        loadTransactions();
    }

    // initialize the recycler view for transaction list
    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        new ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(recyclerView);
        listAdapter = new listAdapter(this);
        recyclerView.setAdapter(listAdapter);
    }

    // get the transactions from the database to display in the recycler view
    private void loadTransactions() {
        transactionList = viewModel.getAllTransactions(this.getApplicationContext());
        listAdapter.setTransactionList(transactionList);
    }

    // functionality for transaction list items to be swiped and deleted
    ItemTouchHelper.SimpleCallback itemTouchHelperCallBack = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            viewModel.removeFromDatabase(transactionList.get(viewHolder.getAdapterPosition()),getApplicationContext());
            transactionList.remove(viewHolder.getAdapterPosition());
            listAdapter.notifyDataSetChanged();
        }
    };
}