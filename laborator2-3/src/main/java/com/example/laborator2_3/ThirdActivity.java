package com.example.laborator2_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Bundle extras = getIntent().getExtras();
        String mesaj = extras.getString("mesaj");
        int v1 = extras.getInt("valoare1");
        int v2 = extras.getInt("valoare2");

        Toast.makeText(this, mesaj + " (" + v1 + ", " + v2 + ")", Toast.LENGTH_LONG).show();

        Button btn = findViewById(R.id.btnSendBack);
        btn.setOnClickListener(v -> {
            Intent rezultat = new Intent();
            rezultat.putExtra("mesaj_raspuns", "Răspuns din activitatea 3");
            rezultat.putExtra("suma", v1 + v2);
            setResult(RESULT_OK, rezultat);
            finish();
        });
    }
}