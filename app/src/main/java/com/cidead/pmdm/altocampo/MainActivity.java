package com.cidead.pmdm.altocampo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;

public class MainActivity extends AppCompatActivity {

    Switch swichModoOscuro;
    TextView texto;
    Spinner idiomas, menu;

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
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

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
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

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



        menu = findViewById(R.id.hamburgesa);



        ArrayAdapter<CharSequence> adaptador =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.opciones,
                        android.R.layout.simple_spinner_item
                );

        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );


        texto = findViewById(R.id.textView);
        menu.setAdapter(adaptador);

        menu.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        switch (position) {
                            case 0:
                                //ir a inicio
                                break;
                            case 1:
                                //ir a rutas
                                break;
                            case 2:
                                //ir a gastronomia
                                break;
                            case 3:
                                //ir a alojamiento
                                break;
                            case 4:
                                //ir a actividades
                                break;
                            case 5:
                                //ir a seo
                                break;
                            case 6:
                                //ir a agenda
                                break;
                            case 7:
                                //ir a guardado
                                break;
                            case 8:
                                //ir a ajustes
                                break;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // No se ha seleccionado ningún idioma
                    }
                }
        );

    }

    // ---------------------------------
    // CAMBIAR IDIOMA
    // ---------------------------------

    public void cambiarIdioma(String codigoIdioma) {

        LocaleListCompat locales = LocaleListCompat.forLanguageTags(codigoIdioma);

        AppCompatDelegate.setApplicationLocales(locales);
    }
}