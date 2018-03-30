package com.example.antoine.pizzeria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class PizzeriaTableActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnVali;
    private EditText iptTable;
    static String idTable;
    final static String keyTabl = "CLE_TABL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzeria_table);

        btnVali = findViewById(R.id.btnVali);
        btnVali.setOnClickListener(this);
        btnVali.setEnabled(false);

        iptTable = findViewById(R.id.iptTabl);
        iptTable.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }


            /**
             * Vérifie que le numéro de la table est correct
             * En fonction de cette vérification : met à jour le boutton pour qu'il puisse être appuyable ou non
             * @param charSequence
             * @param i
             * @param i1
             * @param i2
             */
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Vérifie que le numéro de la table soit bien valide
                if(iptTable.getText() != null && !iptTable.getText().toString().matches("") && !iptTable.getText().toString().matches("0") && !(iptTable.getText().toString().length() > 2)) {
                    btnVali.setEnabled(true);
                } else {
                    btnVali.setEnabled(false);
                }
            }


            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    /**
     * Permet de passer à la page avec les pizzas
     * @param v
     */
    public void onClick(View v) {
        String tempId = iptTable.getText().toString();
        // Si le numéro de la pizza est infèrieur à 10 on rajoute un 0 devant pour que le serveur accepte les futurs message
        idTable = (tempId.length() > 0 && tempId.length() < 2) ? "0" + tempId : tempId;
        Intent intent = new Intent(this, PizzeriaMainActivity.class);
        // On met dans le intent le numéro de la table renseignée
        intent.putExtra(keyTabl, idTable);
        // On lance l'activité avec les pizzas
        startActivity(intent);
    }
}
