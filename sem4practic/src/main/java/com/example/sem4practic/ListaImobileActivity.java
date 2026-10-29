package com.example.sem4practic;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListaImobileActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Imobil> listaImobile;
    private ArrayAdapter<Imobil> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista_imobile);

        listView = findViewById(R.id.listViewImobile);

        if(getIntent().hasExtra("lista_imobile"))
        {
            listaImobile = (ArrayList<Imobil>) getIntent().getSerializableExtra("lista_imobile");
        }else
        {
            listaImobile = new ArrayList<>();
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaImobile);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) ->
        {
            Imobil selectat = listaImobile.get(position);
            Toast.makeText(this, "Ai selectat: " + selectat.toString(), Toast.LENGTH_SHORT).show();
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