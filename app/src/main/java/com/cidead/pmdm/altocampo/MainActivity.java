package com.cidead.pmdm.altocampo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Spinner idiomas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idiomas = findViewById(R.id.idiomas);
        ArrayAdapter<CharSequence> adaptadorLista = ArrayAdapter.createFromResource(
                this,
                R.array.idiomasLista,
                android.R.layout.simple_spinner_item
        );
        adaptadorLista.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idiomas.setAdapter(adaptadorLista);
        idiomas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}