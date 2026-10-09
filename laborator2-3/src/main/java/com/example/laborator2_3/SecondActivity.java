package com.example.laborator2_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private final ActivityResultLauncher<Intent> thirdLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Bundle extras = result.getData().getExtras();
                    String mesaj = extras.getString("mesaj_raspuns");
                    int suma = extras.getInt("suma");
                    Toast.makeText(this, mesaj + " | Suma = " + suma, Toast.LENGTH_LONG).show();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btn = findViewById(R.id.btnOpenThird);
        btn.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("mesaj", "Salut din activitatea 2!");
            bundle.putInt("valoare1", 5);
            bundle.putInt("valoare2", 7);

            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            intent.putExtras(bundle);
            thirdLauncher.launch(intent);
        });
    }
}