package com.example.sem4practic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class AddImobilAiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_imobil_ai);

        EditText etAdresa = findViewById(R.id.etAdresaAi);
        CheckBox cbParcare = findViewById(R.id.cbParcareAi);
        RadioButton rbApartament = findViewById(R.id.rbApartamentAi);
        RadioButton rbCasa = findViewById(R.id.rbCasaAi);
        Spinner spinnerOras = findViewById(R.id.spinnerOrasAi);
        RatingBar ratingBar = findViewById(R.id.ratingBarAi);
        SwitchCompat switchMobilat = findViewById(R.id.switchMobilatAi);
        Button btnSalveaza = findViewById(R.id.btnSalveazaAi);

        String[] optiuniOrase = {"București", "Cluj-Napoca", "Timișoara", "Brașov", "Iași"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optiuniOrase);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOras.setAdapter(adapter);

        btnSalveaza.setOnClickListener(v -> {
            String adresa = etAdresa.getText().toString();
            boolean areParcare = cbParcare.isChecked();
            String tip = rbApartament.isChecked() ? "Apartament" : (rbCasa.isChecked() ? "Casă" : "Nespecificat");
            String oras = spinnerOras.getSelectedItem().toString();
            float rating = ratingBar.getRating();
            boolean mobilat = switchMobilat.isChecked();

            if (adresa.trim().isEmpty()) {
                Toast.makeText(this, "Completează adresa!", Toast.LENGTH_SHORT).show();
                return;
            }

            Imobil imobil = new Imobil(adresa, areParcare, tip, oras, rating, mobilat);
            Intent intent = new Intent();
            intent.putExtra("imobil_nou", imobil);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}