
package com.cidead.pmdm.altocampo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;

import com.cidead.pmdm.altocampo.R;

public class MainActivity extends AppCompatActivity {

    Switch swichModoOscuro;
    Spinner idiomas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("ajustes", MODE_PRIVATE);

        // Recuperar el modo oscuro guardado
        boolean modoOscuro = prefs.getBoolean("modo_oscuro", false);

        if (modoOscuro) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        setContentView(R.layout.activity_main);

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
    }

    // ---------------------------------
    // CAMBIAR IDIOMA
    // ---------------------------------

    public void cambiarIdioma(String codigoIdioma) {

        LocaleListCompat locales = LocaleListCompat.forLanguageTags(codigoIdioma);

        AppCompatDelegate.setApplicationLocales(locales);
    }
}
