package com.example.antoine.pizzeria;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class IngredientsFragment extends Fragment implements View.OnClickListener {

    private PizzaFragment.OnFragmentInteractionListener mListener;
    private Button btnVali, btnMozz, btnGorg, btnAnch, btnCapr, btnOliv, btnArti, btnJambCru, btnJambCuit;
    public static List<Integer> ingredientsSelected = new ArrayList<>();

    public IngredientsFragment() {
        // Required empty public constructor
    }

    /**
     * Attribut les listener et change la couleur des bouttons en fonction de s'ils ont été séléctionné (rotation principalement)
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ingredients, container, false);

        btnVali = v.findViewById(R.id.btnVali);
        btnVali.setOnClickListener(this);

        btnMozz = v.findViewById(R.id.btnMozz);
        btnMozz.setOnClickListener(this);

        btnGorg = v.findViewById(R.id.btnGorg);
        btnGorg.setOnClickListener(this);

        btnAnch = v.findViewById(R.id.btnAnch);
        btnAnch.setOnClickListener(this);

        btnCapr = v.findViewById(R.id.btnCapr);
        btnCapr.setOnClickListener(this);

        btnOliv = v.findViewById(R.id.btnOliv);
        btnOliv.setOnClickListener(this);

        btnArti = v.findViewById(R.id.btnArti);
        btnArti.setOnClickListener(this);

        btnJambCru = v.findViewById(R.id.btnJambCru);
        btnJambCru.setOnClickListener(this);

        btnJambCuit = v.findViewById(R.id.btnJambCuit);
        btnJambCuit.setOnClickListener(this);

        if(!ingredientsSelected.isEmpty()) {
            for(Integer ing: ingredientsSelected) {
                if(ing == btnMozz.getId()) btnMozz.setBackgroundColor(0x9922c94e);
                if(ing == btnGorg.getId()) btnGorg.setBackgroundColor(0x9922c94e);
                if(ing == btnAnch.getId()) btnAnch.setBackgroundColor(0x9922c94e);
                if(ing == btnCapr.getId()) btnCapr.setBackgroundColor(0x9922c94e);
                if(ing == btnOliv.getId()) btnOliv.setBackgroundColor(0x9922c94e);
                if(ing == btnArti.getId()) btnArti.setBackgroundColor(0x9922c94e);
                if(ing == btnJambCru.getId()) btnJambCru.setBackgroundColor(0x9922c94e);
                if(ing == btnJambCuit.getId()) btnJambCuit.setBackgroundColor(0x9922c94e);
            }
        }

        return v;
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnVali:
                ((PizzeriaMainActivity)getActivity()).returnToPizzaFragment();
                break;
            case R.id.btnMozz:
                toggleButton(btnMozz);
                break;
            case R.id.btnGorg:
                toggleButton(btnGorg);
                break;
            case R.id.btnAnch:
                toggleButton(btnAnch);
                break;
            case R.id.btnCapr:
                toggleButton(btnCapr);
                break;
            case R.id.btnOliv:
                toggleButton(btnOliv);
                break;
            case R.id.btnArti:
                toggleButton(btnArti);
                break;
            case R.id.btnJambCru:
                toggleButton(btnJambCru);
                break;
            case R.id.btnJambCuit:
                toggleButton(btnJambCuit);
                break;
        }
    }

    /**
     * Permet de changer la couleur lors du click
     * Ajout/retire les ingrédients en fonction de sa présence dans la liste
     * @param btn
     */
    private void toggleButton(Button btn) {
        if(ingredientsSelected.contains(btn.getId())) {
            ingredientsSelected.remove((Integer) btn.getId());
            btn.setBackgroundResource(android.R.drawable.btn_default);
        } else {
            ingredientsSelected.add(btn.getId());
            btn.setBackgroundColor(0x9922c94e);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PizzaFragment.OnFragmentInteractionListener) {
            mListener = (PizzaFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
