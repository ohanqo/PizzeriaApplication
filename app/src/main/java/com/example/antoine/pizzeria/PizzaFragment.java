package com.example.antoine.pizzeria;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PizzaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class PizzaFragment extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;
    private String numTabl = PizzeriaMainActivity.numTabl;
    private Button btnRoya, btnHawa, btnMont, btnFrom, btnNapo, btnRacl, btnPann, btnTira;
    public static Button btnPers, btnRein;
    static int nbRoya, nbHawa, nbMont, nbFrom, nbNapo, nbRacl, nbPann, nbTira;

    public PizzaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout., container, false);
        View v = inflater.inflate(R.layout.fragment_pizzas, container, false);

        btnPers = v.findViewById(R.id.btnPers);
        btnPers.setOnClickListener(this);

        btnRoya = v.findViewById(R.id.btnRoya);
        btnRoya.setOnClickListener(this);

        btnHawa = v.findViewById(R.id.btnHawa);
        btnHawa.setOnClickListener(this);

        btnMont = v.findViewById(R.id.btnMont);
        btnMont.setOnClickListener(this);

        btnFrom = v.findViewById(R.id.btnFrom);
        btnFrom.setOnClickListener(this);

        btnNapo = v.findViewById(R.id.btnNapo);
        btnNapo.setOnClickListener(this);

        btnRacl = v.findViewById(R.id.btnRacl);
        btnRacl.setOnClickListener(this);

        btnPann = v.findViewById(R.id.btnPann);
        btnPann.setOnClickListener(this);

        btnTira = v.findViewById(R.id.btnTira);
        btnTira.setOnClickListener(this);

        btnRein = v.findViewById(R.id.btnRein);
        btnRein.setOnClickListener(this);

        if (savedInstanceState != null) {
            int valPers = savedInstanceState.getInt(getResources().getString(R.string.keyPers));
            int valRoya = savedInstanceState.getInt(getResources().getString(R.string.keyRoya));
            int valHawa = savedInstanceState.getInt(getResources().getString(R.string.keyHawa));
            int valMont = savedInstanceState.getInt(getResources().getString(R.string.keyMont));
            int valFrom = savedInstanceState.getInt(getResources().getString(R.string.keyFrom));
            int valNapo = savedInstanceState.getInt(getResources().getString(R.string.keyNapo));
            int valRacl = savedInstanceState.getInt(getResources().getString(R.string.keyRacl));
            int valPann = savedInstanceState.getInt(getResources().getString(R.string.keyPann));
            int valTira = savedInstanceState.getInt(getResources().getString(R.string.keyTira));

            btnPers.setText("Pizza personnalisée : " + String.valueOf(valPers));
            btnRoya.setText("Royale : " + String.valueOf(valRoya));
            btnHawa.setText("Hawai : " +  String.valueOf(valHawa));
            btnMont.setText("Montagnarde : " + String.valueOf(valMont));
            btnFrom.setText("Quatre Fromages : " + String.valueOf(valFrom));
            btnNapo.setText("Napolitaine : " + String.valueOf(valNapo));
            btnRacl.setText("Raclette : " + String.valueOf(valRacl));
            btnPann.setText("Panna Cotta : " + String.valueOf(valPann));
            btnTira.setText("Tiramisu : " + String.valueOf(valTira));

        }

        return v;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPers:
                ((PizzeriaMainActivity)getActivity()).replaceWithIngredientsFragment();
                break;
            case R.id.btnRoya:
                nbRoya++;
                btnRoya.setText("Royale : " + nbRoya);
                System.out.println("Royale " + nbRoya);
                SendOrdering sendRoya = new SendOrdering();
                sendRoya.execute(numTabl+ "Royale");
                break;
            case R.id.btnHawa:
                nbHawa++;
                btnHawa.setText("Hawai : " + nbHawa);
                System.out.println("Hawai " + nbHawa);
                SendOrdering sendHawai = new SendOrdering();
                sendHawai.execute(numTabl + "Hawai");
                break;
            case R.id.btnMont:
                nbMont++;
                btnMont.setText("Montagnarde : " + nbMont);
                System.out.println("Montagnarde " + nbMont);
                SendOrdering sendMont = new SendOrdering();
                sendMont.execute(numTabl + "Montagnarde");
                break;
            case R.id.btnFrom:
                nbFrom++;
                btnFrom.setText("Quatre Fromages : " + nbFrom);
                System.out.println("Quatre Fromages " + nbFrom);
                SendOrdering sendFrom = new SendOrdering();
                sendFrom.execute(numTabl + "Quatre Fromages");
                break;
            case R.id.btnNapo:
                nbNapo++;
                btnNapo.setText("Napolitaine : " + nbNapo);
                System.out.println("Napolitaine " + nbNapo);
                SendOrdering sendNapo = new SendOrdering();
                sendNapo.execute(numTabl + "Napolitaine");
                break;
            case R.id.btnRacl:
                nbRacl++;
                btnRacl.setText("Raclette : " + nbRacl);
                System.out.println("Raclette " + nbRacl);
                SendOrdering sendRacl = new SendOrdering();
                sendRacl.execute(numTabl + "Raclette");
                break;
            case R.id.btnPann:
                nbPann++;
                btnPann.setText("Panna Cotta : " + nbPann);
                System.out.println("Panna Cotta " + nbPann);
                SendOrdering sendPann = new SendOrdering();
                sendPann.execute(numTabl + "Panna Cotta");
                break;
            case R.id.btnTira:
                nbTira++;
                btnTira.setText("Tiramisu : " + nbTira);
                System.out.println("Tiramisu " + nbTira);
                SendOrdering sendTira = new SendOrdering();
                sendTira.execute(numTabl + "Tiramisu");
                break;
            default:
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(getResources().getString(R.string.keyRoya), nbRoya);
        outState.putInt(getResources().getString(R.string.keyHawa), nbHawa);
        outState.putInt(getResources().getString(R.string.keyMont), nbMont);
        outState.putInt(getResources().getString(R.string.keyFrom), nbFrom);
        outState.putInt(getResources().getString(R.string.keyNapo), nbNapo);
        outState.putInt(getResources().getString(R.string.keyRacl), nbRacl);
        outState.putInt(getResources().getString(R.string.keyPann), nbPann);
        outState.putInt(getResources().getString(R.string.keyTira), nbTira);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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

    @Override
    public void onResume() {
        super.onResume();
        btnPers.setText("Pizza personnalisée : " + PizzeriaMainActivity.nbPers);
        btnRoya.setText("Royale : " + nbRoya);
        btnHawa.setText("Hawai : " + nbHawa);
        btnMont.setText("Montagnarde : " + nbMont);
        btnFrom.setText("Quatre Fromages : " + nbFrom);
        btnNapo.setText("Napolitaine : " + nbNapo);
        btnRacl.setText("Raclette : " + nbRacl);
        btnPann.setText("Panna Cotta : " + nbPann);
        btnTira.setText("Tiramisu : " + nbTira);
        applyPreferences();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    protected void applyPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        boolean color = sharedPreferences.getBoolean(String.valueOf(getResources().getText(R.string.keyColor)), true);
        if(color) {
            btnPers.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPizzaButtonDefault));
            btnRoya.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPizzaButtonDefault));
            btnHawa.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPizzaButtonDefault));
            btnMont.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPizzaButtonDefault));
            btnFrom.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPizzaButtonDefault));
            btnNapo.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPizzaButtonDefault));
            btnRacl.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPizzaButtonDefault));
            btnPann.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPizzaButtonDefault));
            btnTira.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPizzaButtonDefault));
            btnRein.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPizzaButtonDefault));
        }
    }
}
