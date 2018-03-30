package com.example.antoine.pizzeria;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PizzeriaMainActivity extends AppCompatActivity implements PizzaFragment.OnFragmentInteractionListener, IngredientsFragment.OnFragmentInteractionListener {

    //private Button btnRoya, btnHawa, btnMont, btnFrom, btnNapo, btnRacl, btnPann, btnTira;
    //static int nbRoya, nbHawa, nbMont, nbFrom, nbNapo, nbRacl, nbPann, nbTira;

    public static TextView txtTabl;
    public static String numTabl;
    // Liste avec les pizzas prêtes
    public static List<String> readyPizzas = new ArrayList<>();
    static int nbPers;

    PreferenceFragment preferenceFragment = new Prefs();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzeria_main);
        /*
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
        */

        // Récupère la vue affichant les messages, ainsi que le numéro de la table depuis l'intent
        Intent intent = getIntent();
        txtTabl = findViewById(R.id.txtTabl);
        numTabl = intent.getStringExtra(PizzeriaTableActivity.keyTabl);
        txtTabl.setText("Commande de la table n°" + numTabl);

        // Si le fragment n'est pas lancé, on le lance
        // Utilisé au démarrage de l'application
        if(findViewById(R.id.fragment) != null) {
            if (savedInstanceState != null) return;
            // On affiche le fragment avec les pizzas
            PizzaFragment pizzaFragment = new PizzaFragment();
            getFragmentManager().beginTransaction().add(R.id.fragment, pizzaFragment).commit();
        }

        // On met à jour la valeur du boutton pizza pérsonnalisée
        if (savedInstanceState != null) {
            int valPers = savedInstanceState.getInt("CLE_PERS");
            PizzaFragment.btnPers.setText("Pizza personnalisée : " + String.valueOf(valPers));
        }

        /*
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
        */
    }

    /*
    public void onClick(View v) {
        switch (v.getId()) {
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
    */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(getResources().getString(R.string.keyPers), nbPers);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {
        //
    }

    /**
     * Permet de revenir à l'écran séléction des pizzas
     */
    public void returnToPizzaFragment() {
        getFragmentManager().popBackStack();
        // Récupère le numéro de la table et le met dans le futur message
        String msg = numTabl;
        // Si des ingrédients ont été séléctionnés
        if (!IngredientsFragment.ingredientsSelected.isEmpty()) {
            // Pour chaque ingrédients on récupère son nom et l'ajoute au message
            for (Integer ing : IngredientsFragment.ingredientsSelected) {
                Button btn = findViewById(ing);
                msg += (btn.getText() + " + ");
            }
            // Incrément le nombre de pizzas personnalisées
            nbPers++;
            // On retire le dernier + ainsi que les espaces
            msg = msg.substring(0, msg.length() - 3);
            // On envoie le message au serveur
            SendOrdering sendCustomPizza = new SendOrdering();
            sendCustomPizza.execute(msg);
            // On affiche le toast de confirmation
            Toast.makeText(this, "Pizza personnalisée commandée.", Toast.LENGTH_LONG).show();
            // Actualise le nombre de pizzas personnalisées sur le boutton
            PizzaFragment.btnPers.setText("Pizza personnalisée : " + nbPers);
            // On vide les ingrédients présent dans la liste
            IngredientsFragment.ingredientsSelected.clear();
        }
    }

    /**
     * Permet d'afficher la page de la pizza personnalisée
     */
    public void replaceWithIngredientsFragment() {
        IngredientsFragment ingredientsFragment = new IngredientsFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragment, ingredientsFragment).addToBackStack(null).commit();
    }


    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("Éxécution -> onStart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        applyPreferences();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Permet d'afficher la page souhaitée, soit la page des pizzas prêtes, soit les préférences
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.btnReady) {
            // Affiche les pizza prêtes
            ReadyPizzaFragment readyPizzaFragment = new ReadyPizzaFragment();
            getFragmentManager().beginTransaction().replace(R.id.fragment, readyPizzaFragment).addToBackStack(null).commit();
        } else {
            // Affiche les préférences
            getFragmentManager().beginTransaction().replace(R.id.fragment, preferenceFragment).addToBackStack(null).commit();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Permet d'appliquer les préférences
     */
    protected void applyPreferences() {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        boolean color = sharedPref.getBoolean(String.valueOf(getResources().getText(R.string.keyColor)), true);
    }

    /**
     * Permet d'afficher les pizzas prêtes
     */
    protected void fillListPizzaReady() {
        // On récupère la textview du fragment prefs
        TextView textView = findViewById(R.id.textViewReadyPizza);
        textView.setSingleLine(false);
        textView.setTextColor(getResources().getColor(R.color.colorText));
        // Si des pizzas sont prêtes
        if(!PizzeriaMainActivity.readyPizzas.isEmpty()) {
            // On effaces l'ancien message
            textView.setText("");
            // On affiche la table et les pizzas prêtes
            for(String pizza: PizzeriaMainActivity.readyPizzas) {
                textView.setText(textView.getText() + pizza + '\n');
            }
        } else {
            textView.setText("Pas de pizza prête.");
        }
    }
}
