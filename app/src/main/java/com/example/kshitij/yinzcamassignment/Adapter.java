package com.example.kshitij.yinzcamassignment;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.Future;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    ArrayList<BigInteger> data;
    Context context;

    public Adapter(ArrayList<BigInteger> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        Future future = PrecomputedTextCompat.getTextFuture(
                data.get(position).toString(), holder.textView.getTextMetricsParamsCompat(), null);
        holder.textView.setTextFuture(future);
    }

    @Override
    public int getItemCount() {

        return data==null?0: data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.fib_series_texxt);
        }
    }

    public void updateList(ArrayList<BigInteger> list){
        data.clear();
        data = list;
        notifyDataSetChanged();
    }
}