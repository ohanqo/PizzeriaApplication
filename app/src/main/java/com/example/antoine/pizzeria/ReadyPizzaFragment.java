package com.example.antoine.pizzeria;


import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadyPizzaFragment extends Fragment {

    private ViewGroup view;

    public ReadyPizzaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ready_pizza, container, false);
    }


    @Override
    public void onResume() {
        super.onResume();
        ((PizzeriaMainActivity)getActivity()).fillListPizzaReady();
    }
}
