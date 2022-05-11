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
        holder.amount.setText(String.valueOf(d));
        //holder.date.setText(this.transactionList.get(position).getDate());
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
