package com.melvin.tmt.dao;

import android.util.Log;

import com.melvin.tmt.model.PuntoVenta;
import com.melvin.tmt.model.PuntoVentaContainer;
import com.melvin.tmt.util.ResultListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaoInternetPuntoVenta extends DaoHelper{

    public static final String BASE_URL = "https://api.myjson.com";
    private ServicePuntoVenta servicePuntoVenta;

    public DaoInternetPuntoVenta(){
        super(BASE_URL);
        servicePuntoVenta = retrofit.create(ServicePuntoVenta.class);
    }

    public void obtenerPuntosVenta(final ResultListener<List<PuntoVenta>> listenerController){

        Call<PuntoVentaContainer> call = servicePuntoVenta.obtenerPuntosVenta();
        call.enqueue(new Callback<PuntoVentaContainer>() {
            @Override
            public void onResponse(Call<PuntoVentaContainer> call, Response<PuntoVentaContainer> response) {
                PuntoVentaContainer container = response.body();
                List<PuntoVenta> datos = container.getData();
                listenerController.finish(datos);
            }

            @Override
            public void onFailure(Call<PuntoVentaContainer> call, Throwable t) {
                Log.d("Error", t.toString());
            }
        });
    }
}
