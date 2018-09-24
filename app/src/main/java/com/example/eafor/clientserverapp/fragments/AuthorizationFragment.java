package com.example.eafor.clientserverapp.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.eafor.clientserverapp.R;


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

        btnOffline = view.findViewById(R.id.offline);
        btnOnline = view.findViewById(R.id.online);
        btnOffline.setOnClickListener(v -> changeFragment(1));
        btnOnline.setOnClickListener(v -> changeFragment(2));

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //unbinder.unbind();
    }


    private void changeFragment(int fragment) {
        if (fragment == 1) {
            FragmentOffline fragmentOffline = new FragmentOffline();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction().replace(R.id.fragment, fragmentOffline);
            ft.commit();
        } else if (fragment == 2) {
            //Здесь должно быть организовано соединение, и, если оно успешное, то, переход ко второму фрагменту.
            FragmentOnline main_fragment = new FragmentOnline();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction().replace(R.id.fragment, main_fragment);
            ft.commit();
        }

    }
}
