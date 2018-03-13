package com.example.antoine.pizzeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PizzeriaMainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnRoya, btnHawa, btnMont, btnFrom, btnNapo, btnRacl, btnPann, btnTira;
    static int nbRoya, nbHawa, nbMont, nbFrom, nbNapo, nbRacl, nbPann, nbTira;

    private TextView txtTabl;
    private int numTabl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzeria_main);

        btnRoya = findViewById(R.id.btnRoya);
        btnRoya.setOnClickListener(this);

        btnHawa = findViewById(R.id.btnHawa);
        btnHawa.setOnClickListener(this);

        btnMont = findViewById(R.id.btnMont);
        btnMont.setOnClickListener(this);

        btnFrom = findViewById(R.id.btnFrom);
        btnFrom.setOnClickListener(this);

        btnNapo = findViewById(R.id.btnNapo);
        btnNapo.setOnClickListener(this);

        btnRacl = findViewById(R.id.btnRacl);
        btnRacl.setOnClickListener(this);

        btnPann = findViewById(R.id.btnPann);
        btnPann.setOnClickListener(this);

        btnTira = findViewById(R.id.btnTira);
        btnTira.setOnClickListener(this);

        Intent intent = getIntent();
        txtTabl = findViewById(R.id.txtTabl);
        numTabl = intent.getIntExtra(PizzeriaTableActivity.keyTabl, 1);
        txtTabl.setText("Commande de la table n°" + numTabl);

        if (savedInstanceState != null) {

            int valRoya = savedInstanceState.getInt(getResources().getString(R.string.keyRoya));
            int valHawa = savedInstanceState.getInt(getResources().getString(R.string.keyHawa));
            int valMont = savedInstanceState.getInt(getResources().getString(R.string.keyMont));
            int valFrom = savedInstanceState.getInt(getResources().getString(R.string.keyFrom));
            int valNapo = savedInstanceState.getInt(getResources().getString(R.string.keyNapo));
            int valRacl = savedInstanceState.getInt(getResources().getString(R.string.keyRacl));
            int valPann = savedInstanceState.getInt(getResources().getString(R.string.keyPann));
            int valTira = savedInstanceState.getInt(getResources().getString(R.string.keyTira));

            btnRoya.setText("Royale : " + String.valueOf(valRoya));
            btnHawa.setText("Hawai : " +  String.valueOf(valHawa));
            btnMont.setText("Montagnarde : " + String.valueOf(valMont));
            btnFrom.setText("Quatre Fromages : " + String.valueOf(valFrom));
            btnNapo.setText("Napolitaine : " + String.valueOf(valNapo));
            btnRacl.setText("Raclette : " + String.valueOf(valRacl));
            btnPann.setText("Panna Cotta : " + String.valueOf(valPann));
            btnTira.setText("Tiramisu : " + String.valueOf(valTira));

        }
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRoya:
                nbRoya++;
                btnRoya.setText("Royale : " + nbRoya);
                System.out.println("Royale " + nbRoya);
                SendOrdering sendRoya = new SendOrdering(numTabl, "Royale");
                sendRoya.execute();
                break;
            case R.id.btnHawa:
                nbHawa++;
                btnHawa.setText("Hawai : " + nbHawa);
                System.out.println("Hawai " + nbHawa);
                SendOrdering sendHawai = new SendOrdering(numTabl, "Hawai");
                sendHawai.execute();
                break;
            case R.id.btnMont:
                nbMont++;
                btnMont.setText("Montagnarde : " + nbMont);
                System.out.println("Montagnarde " + nbMont);
                SendOrdering sendMont = new SendOrdering(numTabl, "Montagnarde");
                sendMont.execute();
                break;
            case R.id.btnFrom:
                nbFrom++;
                btnFrom.setText("Quatre Fromages : " + nbFrom);
                System.out.println("Quatre Fromages " + nbFrom);
                SendOrdering sendFrom = new SendOrdering(numTabl, "Quatre Fromages");
                sendFrom.execute();
                break;
            case R.id.btnNapo:
                nbNapo++;
                btnNapo.setText("Napolitaine : " + nbNapo);
                System.out.println("Napolitaine " + nbNapo);
                SendOrdering sendNapo = new SendOrdering(numTabl, "Napolitaine");
                sendNapo.execute();
                break;
            case R.id.btnRacl:
                nbRacl++;
                btnRacl.setText("Raclette : " + nbRacl);
                System.out.println("Raclette " + nbRacl);
                SendOrdering sendRacl = new SendOrdering(numTabl, "Raclette");
                sendRacl.execute();
                break;
            case R.id.btnPann:
                nbPann++;
                btnPann.setText("Panna Cotta : " + nbPann);
                System.out.println("Panna Cotta " + nbPann);
                SendOrdering sendPann = new SendOrdering(numTabl, "Panna Cotta");
                sendPann.execute();
                break;
            case R.id.btnTira:
                nbTira++;
                btnTira.setText("Tiramisu : " + nbTira);
                System.out.println("Tiramisu " + nbTira);
                SendOrdering sendTira = new SendOrdering(numTabl, "Tiramisu");
                sendTira.execute();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
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

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("Éxécution -> onStart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Éxécution -> onResume()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("Éxécution -> onPause()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("Éxécution -> onStop()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("Éxécution -> onDestroy()");
    }
    /*
    @Override
    protected void onRestoreInstanceState(Bundle outState) {
        super.onRestoreInstanceState(outState);
        btnRoya.setText("Royale : " + outState.get(getResources().getString(R.string.keyRoya)));
        btnHawa.setText("Hawai : " +  outState.get(getResources().getString(R.string.keyHawa)));
        btnMont.setText("Montagnarde : " + outState.get(getResources().getString(R.string.keyMont)));
        btnFrom.setText("Quatre Fromages : " + outState.get(getResources().getString(R.string.keyFrom)));
        btnNapo.setText("Napolitaine : " + outState.get(getResources().getString(R.string.keyNapo)));
        btnRacl.setText("Raclette : " + outState.get(getResources().getString(R.string.keyRacl)));
        btnPann.setText("Panna Cotta : " + outState.get(getResources().getString(R.string.keyPann)));
        btnTira.setText("Tiramisu : " + outState.get(getResources().getString(R.string.keyTira)));
    }
    */
}
