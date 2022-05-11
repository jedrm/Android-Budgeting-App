package com.example.budgetingapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.budgetingapp.R;
import com.example.budgetingapp.model.Transaction;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
import java.util.List;

public class listAdapter extends RecyclerView.Adapter<listAdapter.MyViewHolder> {

    private Context context;
    private List<Transaction> transactionList;
    public listAdapter(Context context) {
        this.context = context;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public listAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listAdapter.MyViewHolder holder, int position) {
        holder.name.setText(this.transactionList.get(position).getMerchantName());
        holder.type.setText(this.transactionList.get(position).getTransactionType());
        int INT_amount = this.transactionList.get(position).getAmount();
        Double d = Double.valueOf(INT_amount);
        d = d/100;
        String money = String.valueOf(d);
        // check that our amount has two 0's following the decimal
        if(money.charAt(money.length() -2) == '.') {
            String m2 = money.concat("0");
            holder.amount.setText(m2);
        }
        else {holder.amount.setText(money);}
        Date date = this.transactionList.get(position).getDate();
        String s = date.toString();
        holder.date.setText(s);
    }

    @Override
    public int getItemCount() {
        return this.transactionList.size();
    }
    public class MyViewHolder extends  RecyclerView.ViewHolder {
        TextView name,type,amount,date;
        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            type = view.findViewById(R.id.type);
            amount = view.findViewById(R.id.amount);
            date = view.findViewById(R.id.date);

        }
    }
}
