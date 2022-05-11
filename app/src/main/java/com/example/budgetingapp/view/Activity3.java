package com.example.budgetingapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.budgetingapp.R;
import com.example.budgetingapp.model.BudgetingAppDatabase;
import com.example.budgetingapp.model.Transaction;
import com.example.budgetingapp.viewmodel.ApplicationViewModel;

import java.util.Date;

public class Activity3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    // TODO: (@Front-End) Fix activity so transactions can actually be stored
    // TODO: (@Front-End) Allow user to input transaction name and cycle
    private ApplicationViewModel viewModel = new ApplicationViewModel();
    //private Transaction transaction;
    private Spinner spinner;
    private TextView amount;
    private String name;
    private Date date;
    //private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        getSupportActionBar().hide();

        spinner = findViewById(R.id.transaction_menu);
        amount = findViewById(R.id.moneyAmount);

        ImageButton backButton = (ImageButton) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Activity3.this, Activity2.class));
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.transaction_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Button doneButton = (Button) findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                saveData();
                String choice = spinner.getSelectedItem().toString();
                if (!choice.equals("")) {
                    //Toast.makeText(Activity3.this, "Transaction added!", Toast.LENGTH_SHORT).show();
                    // TODO: Pass in information input by user to be displayed in activity 2
                    startActivity(new Intent(Activity3.this, Activity2.class));
                }
                else {
                    Toast.makeText(Activity3.this, "Select a transaction type!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    // TODO: Add transaction limit
    public void addNum(View v) {

        // Toast.makeText(Activity3.this, "Number pressed!", Toast.LENGTH_LONG).show();

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

    private void saveData() {

        spinner = findViewById(R.id.transaction_menu);
        amount = findViewById(R.id.moneyAmount);

        String transaction_type = spinner.getSelectedItem().toString();
        String transaction_name = "DEFAULT";
        date = new Date();
        String s = (amount.getText().toString()).substring(1);
        int transaction_amount = Double.valueOf(s).intValue();
        if(!transaction_type.equals("") && transaction_amount > 0 && transaction_name != null) {
            Transaction transaction = new Transaction(date,transaction_amount,transaction_name,transaction_type);
            /*transaction.setTransactionType(transaction_type);
            transaction.setAmount(transaction_amount);
            transaction.setMerchantName(transaction_name);
            transaction.setDate(date); */
            viewModel.insertToDatabase(transaction,getApplicationContext());
            //BudgetingAppDatabase.getInstance(getApplicationContext()).transaction_dao().insertTransaction(transaction);
            Toast.makeText(this,"DATA SAVED!",Toast.LENGTH_SHORT).show();
        }

    }

}