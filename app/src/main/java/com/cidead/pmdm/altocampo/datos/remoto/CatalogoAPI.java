package com.cidead.pmdm.altocampo.datos.remoto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CatalogoAPI {

    @GET("api/rutas/{id}")
    Call<DtsRuta> obtenerRuta(@Path("id") long id, @Query("idioma") String idioma);
}
