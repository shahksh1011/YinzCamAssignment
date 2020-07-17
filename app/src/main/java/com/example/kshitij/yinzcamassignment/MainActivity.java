package com.example.kshitij.yinzcamassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    Button button ;
    EditText num;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        button = findViewById(R.id.button);
        num = findViewById(R.id.editText);
        progressBar = findViewById(R.id.progressBar);
        num.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "1000")});
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(new ArrayList<BigInteger>(), this);
        recyclerView.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = num.getText().toString();
                if(!r.matches("")){

                    populateDate(Integer.parseInt(r));
                }
            }
        });


    }

    public void populateDate(int n){
        FibonacciSeries f = new FibonacciSeries(this);
        f.execute(n);
    }

    public void updateUi(ArrayList<BigInteger> list){
        adapter.updateList(list);
    }

}
