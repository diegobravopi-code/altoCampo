package com.cidead.pmdm.altocampo.datos.repositorio;

import android.util.Log;

import com.cidead.pmdm.altocampo.BuildConfig;
import com.cidead.pmdm.altocampo.datos.remoto.CatalogoAPI;
import com.cidead.pmdm.altocampo.datos.remoto.DtsRuta;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RutaRepositorio {

    public interface Resultado {
        void alExito(DtsRuta ruta);
        void alError();
    }

    private final CatalogoAPI api;

    public RutaRepositorio() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(CatalogoAPI.class);
    }

    public Call<DtsRuta> obtenerRuta(long id, String idioma, Resultado cb) {
        Call<DtsRuta> llamada = api.obtenerRuta(id, idioma);
        llamada.enqueue(new Callback<DtsRuta>() {
            @Override
            public void onResponse(Call<DtsRuta> call, Response<DtsRuta> resp) {
                if (resp.isSuccessful() && resp.body() != null) {
                    cb.alExito(resp.body());
                } else {
                    Log.e("RutaRepo", "HTTP " + resp.code() + " en " + call.request().url());
                    cb.alError();
                }
            }

            @Override
            public void onFailure(Call<DtsRuta> call, Throwable t) {
                Log.e("RutaRepo", "Fallo de red en " + call.request().url(), t);
                if (!call.isCanceled()) cb.alError();
            }
        });
        return llamada;
    }
}