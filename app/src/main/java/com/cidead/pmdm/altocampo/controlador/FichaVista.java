package com.cidead.pmdm.altocampo.controlador;

import com.cidead.pmdm.altocampo.datos.remoto.DtsRuta;

public interface FichaVista {

    void mostrarCarga();
    void mostrarRuta(DtsRuta ruta);
    void mostrarError();
}
