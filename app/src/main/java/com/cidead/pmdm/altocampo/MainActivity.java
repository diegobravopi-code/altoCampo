package com.cidead.pmdm.altocampo;

import static androidx.core.app.ActivityCompat.recreate;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;

import java.util.Locale;

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
                switch(parent.toString()){
                    case "Español":
                        cambiarIdioma("es");
                        break;
                    case "English":
                        cambiarIdioma("en");
                        break;
                }
            }
        });
    }
    public void cambiarIdioma(String codigoIdioma) {
        Locale locale = new Locale(codigoIdioma);
        Locale.setDefault(locale);

        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());

        // Es necesario recrear la Activity actual para que aplique los nuevos strings
        recreate();
    }
}