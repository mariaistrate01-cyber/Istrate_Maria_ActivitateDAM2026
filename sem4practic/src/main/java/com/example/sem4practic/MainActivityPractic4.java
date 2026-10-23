package com.example.sem4practic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityPractic4 extends AppCompatActivity {

    private TextView tvRezultat;
    private final ActivityResultLauncher<Intent> launcherAdaugare = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {

                    Imobil imobil = (Imobil) result.getData().getSerializableExtra("imobil_nou");

                    if (imobil != null) {
                        tvRezultat.setText(imobil.toString());

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

        Button btnDeschideFormularAi = findViewById(R.id.btnDeschideFormularAi);
        btnDeschideFormularAi.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityPractic4.this, AddImobilAiActivity.class);
            launcherAdaugare.launch(intent);
        });
    }
}