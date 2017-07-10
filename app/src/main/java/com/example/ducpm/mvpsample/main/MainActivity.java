package com.example.ducpm.mvpsample.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ducpm.mvpsample.R;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onActionSuccess() {
    }

    @Override
    public void onActionFailed() {
    }
}
