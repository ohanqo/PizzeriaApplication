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

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(iptTable.getText() != null && !iptTable.getText().toString().matches("")) {
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

    public void onClick(View v) {
        String tempId = iptTable.getText().toString();
        idTable = (tempId.length() > 0 && tempId.length() < 2) ? "0" + tempId : tempId;
        System.out.println(idTable);
        Intent intent = new Intent(this, PizzeriaMainActivity.class);
        intent.putExtra(keyTabl, idTable);
        startActivity(intent);
    }

}
