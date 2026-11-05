package com.example.sem4practic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivityPractic4 extends AppCompatActivity {

    private TextView tvRezultat;
    private ArrayList<Imobil> listaImobile = new ArrayList<>();
    private final ActivityResultLauncher<Intent> launcherAdaugare = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {

                    Imobil imobil = (Imobil) result.getData().getParcelableExtra("imobil_nou");

                    if (imobil != null) {
                        listaImobile.add(imobil);

                        tvRezultat.setText(imobil.getAdresa());

                        Toast.makeText(this, "Adăugat: " + imobil.toString(), Toast.LENGTH_LONG).show();
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_practic4);

        tvRezultat = findViewById(R.id.tvRezultat);
        Button btnDeschideFormular = findViewById(R.id.btnDeschideFormular);

        btnDeschideFormular.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityPractic4.this, AddImobilActivity.class);
            launcherAdaugare.launch(intent);
        });

        Button btnVeziLista = findViewById(R.id.btnVeziLista);

        Button btnDeschideFormularAi = findViewById(R.id.btnDeschideFormularAi);

        btnDeschideFormularAi.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityPractic4.this, AddImobilAiActivity.class);
            launcherAdaugare.launch(intent);
        });

        btnVeziLista.setOnClickListener(v->{
            Intent intent = new Intent(MainActivityPractic4.this, ListaImobileActivity.class);
            intent.putParcelableArrayListExtra("lista_imobile", listaImobile);
            startActivity(intent);
        });
    }
}