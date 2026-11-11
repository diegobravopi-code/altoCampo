package com.cidead.pmdm.altocampo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;

import java.util.Arrays;
import java.util.List;

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



        /*menu = findViewById(R.id.hamburgesa);
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
        );*/




        ImageView imageView = findViewById(R.id.imageViewTrigger);
        Spinner spinner = findViewById(R.id.mySpinner);

        // 2. Definir los datos que contendrá el Spinner
        List<String> opciones = Arrays.asList(getResources().getStringArray(R.array.opciones));

        // 3. Crear y asignar el adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                opciones
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // 4. Configurar qué sucede cuando el usuario selecciona una opción
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elementoSeleccionado = opciones.get(position);
                Toast.makeText(MainActivity.this, "Elegiste: " + elementoSeleccionado, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Opcional: acciones si no hay nada seleccionado
            }
        });

        // 5. ¡Magia! Hacer que al hacer clic en la ImageView se abra el Spinner
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.performClick();
            }
        });

    }

    // ---------------------------------
    // CAMBIAR IDIOMA
    // ---------------------------------

    public void cambiarIdioma(String codigoIdioma) {

        LocaleListCompat locales = LocaleListCompat.forLanguageTags(codigoIdioma);

        AppCompatDelegate.setApplicationLocales(locales);
    }
}