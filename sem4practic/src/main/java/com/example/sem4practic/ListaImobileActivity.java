package com.example.sem4practic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListaImobileActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Imobil> listaImobile;
    private ImobilAdapter adapter;

    private final ActivityResultLauncher<Intent> editLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if(result.getResultCode() == RESULT_OK && result.getData() != null)
                {
                    Intent data = result.getData();
                    Imobil imobilModificat = data.getParcelableExtra("IMOBIL_MODIFICAT");
                    int pozitie = data.getIntExtra("POZITIE", -1);

                    if(pozitie != -1 && imobilModificat != null)
                    {
                        listaImobile.set(pozitie,imobilModificat);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(this, "Imobil modificat cu succes!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista_imobile);

        listView = findViewById(R.id.listViewImobile);

        if(getIntent().hasExtra("lista_imobile"))
        {
            listaImobile = getIntent().getParcelableExtra("lista_imobile");
        }else
        {
            listaImobile = new ArrayList<>();
        }

        adapter = new ImobilAdapter(listaImobile, this, R.layout.item_imobil);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) ->
        {
            Imobil selectat = listaImobile.get(position);
            Intent intent = new Intent(ListaImobileActivity.this, AddImobilActivity.class);
            intent.putExtra("IMOBIL_EDIT",selectat);
            intent.putExtra("POZITIE", position);
            editLauncher.launch(intent);
        });

        listView.setOnItemLongClickListener((parent, view, position, id) ->
                {
                    listaImobile.remove(position);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(this, "Imobil sters", Toast.LENGTH_SHORT).show();
                    return true;
                }
        );
    }
}