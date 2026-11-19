package com.cidead.pmdm.altocampo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;

import com.cidead.pmdm.altocampo.vista.FichaRutaActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch swichModoOscuro;
    private Spinner idiomas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        configurarModoOscuro();
        configurarSelectorIdioma();
        configurarMenu();

        findViewById(R.id.btnProbarFicha).setOnClickListener(v -> abrirFicha());
    }

    // ---------------------------------
    // MODO OSCURO (se guarda la preferencia)
    // ---------------------------------
    private void configurarModoOscuro() {
        SharedPreferences prefs = getSharedPreferences("ajustes", MODE_PRIVATE);
        boolean modoOscuro = prefs.getBoolean("modo_oscuro", false);

        AppCompatDelegate.setDefaultNightMode(modoOscuro
                ? AppCompatDelegate.MODE_NIGHT_YES
                : AppCompatDelegate.MODE_NIGHT_NO);

        swichModoOscuro = findViewById(R.id.switchDarkMode);
        swichModoOscuro.setChecked(modoOscuro);
        swichModoOscuro.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.edit().putBoolean("modo_oscuro", isChecked).apply();
            AppCompatDelegate.setDefaultNightMode(isChecked
                    ? AppCompatDelegate.MODE_NIGHT_YES
                    : AppCompatDelegate.MODE_NIGHT_NO);
        });
    }

    // ---------------------------------
    // SELECTOR DE IDIOMAS
    // ---------------------------------
    private void configurarSelectorIdioma() {
        idiomas = findViewById(R.id.idiomas);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(
                this, R.array.idiomasLista, android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idiomas.setAdapter(adaptador);

        // Marca el idioma actual ANTES de poner el listener, para que no se dispare solo
        idiomas.setSelection(idiomaActual().equals("en") ? 1 : 0, false);

        idiomas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String codigo = position == 1 ? "en" : "es";
                // Solo cambia si es distinto: evita volver al espanol al recrearse la pantalla
                if (!codigo.equals(idiomaActual())) {
                    cambiarIdioma(codigo);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No se ha seleccionado ningun idioma
            }
        });
    }

    private String idiomaActual() {
        return getResources().getConfiguration().getLocales().get(0).getLanguage();
    }

    public void cambiarIdioma(String codigoIdioma) {
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(codigoIdioma));
    }

    // ---------------------------------
    // MENU (icono de las tres rayas)
    // ---------------------------------
    private void configurarMenu() {
        ImageView icono = findViewById(R.id.imageViewTrigger);
        String[] opciones = getResources().getStringArray(R.array.opciones);

        icono.setOnClickListener(v -> {
            PopupMenu menu = new PopupMenu(this, v);
            for (int i = 0; i < opciones.length; i++) {
                menu.getMenu().add(0, i, i, opciones[i]);
            }
            menu.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == 1) {
                    abrirFicha(); // Rutas
                } else {
                    // Resto de secciones: pendientes de tareas posteriores
                    Toast.makeText(this, getString(R.string.elegiste, item.getTitle()),
                            Toast.LENGTH_SHORT).show();
                }
                return true;
            });
            menu.show();
        });
    }

    private void abrirFicha() {
        startActivity(new Intent(this, FichaRutaActivity.class));
    }
}