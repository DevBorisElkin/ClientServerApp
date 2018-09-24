package com.example.eafor.clientserverapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;


import com.example.eafor.clientserverapp.fragments.AuthorizationFragment;


public class MainActivity extends AppCompatActivity {

    public static final int FIELD_SIZE = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main);
        initUI();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initUI() {
        AuthorizationFragment auth_fragment = new AuthorizationFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.fragment, auth_fragment);
        ft.commit();
    }
}

