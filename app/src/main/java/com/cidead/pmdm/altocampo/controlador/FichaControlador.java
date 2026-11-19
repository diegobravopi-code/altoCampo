package com.cidead.pmdm.altocampo.controlador;

import com.cidead.pmdm.altocampo.datos.remoto.DtsRuta;
import com.cidead.pmdm.altocampo.datos.repositorio.RutaRepositorio;

import retrofit2.Call;

public class FichaControlador {

    private FichaVista vista;
    private final RutaRepositorio repo = new RutaRepositorio();
    private Call<DtsRuta> llamadaActual;

    public FichaControlador(FichaVista vista) {
        this.vista = vista;
    }

    public void cargarRuta(long id, String idioma) {
        vista.mostrarCarga();
        llamadaActual = repo.obtenerRuta(id, idioma, new RutaRepositorio.Resultado() {
            @Override
            public void alExito(DtsRuta ruta) {
                if (vista != null) vista.mostrarRuta(ruta);
            }

            @Override
            public void alError() {
                if (vista != null) vista.mostrarError();
            }
        });
    }

    public void liberar() {
        vista = null;
        if (llamadaActual != null) llamadaActual.cancel();
    }
}