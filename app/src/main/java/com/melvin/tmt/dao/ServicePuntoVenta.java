package com.melvin.tmt.dao;

import com.melvin.tmt.model.PuntoVentaContainer;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicePuntoVenta {

    @GET("/bins/vok5m")
    Call<PuntoVentaContainer> obtenerPuntosVenta();
}
