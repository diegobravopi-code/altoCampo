package com.cidead.pmdm.altocampo.vista;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cidead.pmdm.altocampo.R;
import com.cidead.pmdm.altocampo.controlador.FichaControlador;
import com.cidead.pmdm.altocampo.controlador.FichaVista;
import com.cidead.pmdm.altocampo.datos.remoto.DtsRuta;

public class FichaRutaActivity extends AppCompatActivity implements FichaVista {

    private FichaControlador controlador;
    private ProgressBar progreso;
    private TextView txtTitulo, txtDistancia, txtError;
    private Button btnReintentar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_ruta);

        progreso = findViewById(R.id.progreso);
        txtTitulo = findViewById(R.id.txtTitulo);
        txtDistancia = findViewById(R.id.txtDistancia);
        txtError = findViewById(R.id.txtError);
        btnReintentar = findViewById(R.id.btnReintentar);

        String idioma = getResources().getConfiguration().getLocales().get(0)
                .getLanguage().equals("en") ? "en" : "es";

        controlador = new FichaControlador(this);
        btnReintentar.setOnClickListener(v -> controlador.cargarRuta(1, idioma));
        controlador.cargarRuta(1, idioma);
    }

    @Override
    public void mostrarCarga() {
        progreso.setVisibility(View.VISIBLE);
        txtError.setVisibility(View.GONE);
        btnReintentar.setVisibility(View.GONE);
    }

    @Override
    public void mostrarRuta(DtsRuta ruta) {
        progreso.setVisibility(View.GONE);
        txtTitulo.setText(ruta.titulo);
        txtDistancia.setText(getString(R.string.distancia_km, ruta.distanciaKm));
    }

    @Override
    public void mostrarError() {
        progreso.setVisibility(View.GONE);
        txtError.setVisibility(View.VISIBLE);
        btnReintentar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        controlador.liberar();
    }
}