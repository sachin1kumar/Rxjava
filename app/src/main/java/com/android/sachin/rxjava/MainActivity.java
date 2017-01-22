package com.android.sachin.rxjava;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.Observer;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.btn1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   new Loader1().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                new Loader2().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                new Loader3().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);*/
               new Loader2().performOperation2();
            }
        });
/*
        b2 = (Button) findViewById(R.id.btn2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Loader2().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            }
        });

        b3 = (Button) findViewById(R.id.btn3);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Loader3().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            }
        });*/
    }
}
