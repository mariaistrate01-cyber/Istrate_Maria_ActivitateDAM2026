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

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddImobilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_imobil);

        EditText etAdresa = findViewById(R.id.etAdresa);
        CheckBox cbParcare = findViewById(R.id.cbParcare);
        RadioButton rbApartament = findViewById(R.id.rbApartament);
        RadioButton rbCasa = findViewById(R.id.rbCasa);
        Spinner spinnerOras = findViewById(R.id.spinnerOras);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        SwitchCompat switchMobilat = findViewById(R.id.switchMobilat);
        Button btnSalveaza = findViewById(R.id.btnSalveaza);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String[] optiuniOrase = {"București", "Cluj-Napoca", "Timișoara", "Brașov", "Iași"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optiuniOrase);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOras.setAdapter(adapter);

        btnSalveaza.setOnClickListener(v -> {
            String adresa = etAdresa.getText().toString();
            if (adresa.trim().isEmpty()) {
                Toast.makeText(this, "Completează adresa!", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean areParcare = cbParcare.isChecked();
            String tip = rbApartament.isChecked() ? "Apartament" : "Casă";
            String oras = spinnerOras.getSelectedItem().toString();
            float rating = ratingBar.getRating();
            boolean mobilat = switchMobilat.isChecked();

            Imobil imobil = new Imobil(adresa, areParcare, tip, oras, rating, mobilat);
            Intent intent = new Intent();
            intent.putExtra("imobil_nou", imobil);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}