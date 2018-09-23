package com.example.eafor.clientserverapp.fragments;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.eafor.clientserverapp.MainActivity;
import com.example.eafor.clientserverapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AuthorizationFragment extends android.support.v4.app.Fragment {
    Button btnOnline, btnOffline;



    public AuthorizationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_authorization, container, false);
        btnOnline=view.findViewById(R.id.online);
        btnOnline.setOnClickListener(v -> changeFragment());
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //unbinder.unbind();
    }


    private void changeFragment() {
        MainFragment main_fragment=new MainFragment();
        FragmentManager fm=getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction().replace(R.id.fragment, main_fragment);
        ft.commit();
    }
}
