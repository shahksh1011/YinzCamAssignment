package com.example.kshitij.yinzcamassignment;

import android.os.AsyncTask;
import android.view.View;

import java.math.BigInteger;
import java.util.ArrayList;

public class FibonacciSeries extends AsyncTask<Integer, Void , ArrayList<BigInteger>> {

    MainActivity mainActivity;
    public FibonacciSeries(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mainActivity.progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    protected void onPostExecute(ArrayList<BigInteger> bigIntegers) {
        super.onPostExecute(bigIntegers);
        mainActivity.updateUi(bigIntegers);
        mainActivity.progressBar.setVisibility(View.GONE);

    }

    @Override
    protected ArrayList<BigInteger> doInBackground(Integer... integers) {
        int n = integers[0];
        ArrayList<BigInteger> res = new ArrayList<>();
        res.clear();
        res.add(BigInteger.ZERO);
        res.add(BigInteger.ONE);
        if(n<1){
            res.clear();
            res.add(BigInteger.ZERO);
            return res;
        }
        if(n<2)
            return res;
        for (int i = 2; i<=n;i++){
            res.add(res.get(i-1).add(res.get(i-2)));
        }
        return res;
    }

}

