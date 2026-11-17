package com.cidead.pmdm.altocampo;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch swichModoOscuro;
    Spinner idiomas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.inicio);

        SharedPreferences prefs = getSharedPreferences("ajustes", MODE_PRIVATE);

        // Recuperar el modo oscuro guardado
        boolean modoOscuro = prefs.getBoolean("modo_oscuro", false);

        if (modoOscuro) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }


        // ---------------------------------
        // MODO OSCURO
        // ---------------------------------

        swichModoOscuro = findViewById(R.id.switchDarkMode);

        swichModoOscuro.setChecked(modoOscuro);

        swichModoOscuro.setOnCheckedChangeListener(
                (buttonView, isChecked) -> {

                    prefs.edit().putBoolean("modo_oscuro", isChecked).apply();

                    if (isChecked) {
                        AppCompatDelegate.setDefaultNightMode(
                                AppCompatDelegate.MODE_NIGHT_YES
                        );
                    } else {
                        AppCompatDelegate.setDefaultNightMode(
                                AppCompatDelegate.MODE_NIGHT_NO
                        );
                    }
                }
        );

        // ---------------------------------
        // SELECTOR DE IDIOMAS
        // ---------------------------------

        idiomas = findViewById(R.id.idiomas);

        ArrayAdapter<CharSequence> adaptadorLista =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.idiomasLista,
                        android.R.layout.simple_spinner_item
                );

        adaptadorLista.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        idiomas.setAdapter(adaptadorLista);

        idiomas.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {
                            case 0:
                                cambiarIdioma("es");
                                break;
                            case 1:
                                cambiarIdioma("en");
                                break;
                        }
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // No se ha seleccionado ningún idioma
                    }
                }
        );
        // ---------------------------------
        // IR ENTRE MENUS(aun hay que hacer que funcione)
        // ---------------------------------
        ImageView imageView = findViewById(R.id.imageViewTrigger);
        Spinner spinner = findViewById(R.id.mySpinner);
        //Definir los datos que contendrá el Spinner
        List<String> opciones = Arrays.asList(getResources().getStringArray(R.array.opciones));
        //Crear y asignar el adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                opciones
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //Configurar qué sucede cuando el usuario selecciona una opción
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        //ir a inicio
                        Toast.makeText(MainActivity.this, "Elegiste: " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        //ir a rutas
                        Toast.makeText(MainActivity.this, "Elegiste: " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        //ir a gastronomia
                        Toast.makeText(MainActivity.this, "Elegiste: " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        //ir a alojamiento
                        Toast.makeText(MainActivity.this, "Elegiste: " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        //ir a actividades
                        Toast.makeText(MainActivity.this, "Elegiste: " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        //ir a seo
                        Toast.makeText(MainActivity.this, "Elegiste: " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        //ir a agenda
                        Toast.makeText(MainActivity.this, "Elegiste: " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        //ir a guardado
                        Toast.makeText(MainActivity.this, "Elegiste: " + adapter.getItem(position) , Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        //ir a ajustes
                        Toast.makeText(MainActivity.this, "Elegiste: " + adapter.getItem(position) , Toast.LENGTH_SHORT).show();
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Opcional: acciones si no hay nada seleccionado
            }
        });
        //Hacer que al hacer clic en la ImageView se abra el Spinner
        imageView.setOnClickListener(v -> spinner.performClick());

    }
    // ---------------------------------
    // CAMBIAR IDIOMA
    // ---------------------------------
    public void cambiarIdioma(String codigoIdioma) {
        LocaleListCompat locales = LocaleListCompat.forLanguageTags(codigoIdioma);
        AppCompatDelegate.setApplicationLocales(locales);
    }
}