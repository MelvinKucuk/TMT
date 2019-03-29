package com.melvin.tmt.controller;

import android.content.Context;

import com.melvin.tmt.dao.DaoInternetPuntoVenta;
import com.melvin.tmt.model.PuntoVenta;
import com.melvin.tmt.util.ResultListener;
import com.melvin.tmt.util.Util;

import java.util.List;

public class ControllerPuntoVenta {

    public void obtenerPuntoVenta(Context context, final ResultListener<List<PuntoVenta>> listenerView){

        if (Util.hayInternet(context)){
            new DaoInternetPuntoVenta().obtenerPuntosVenta(new ResultListener<List<PuntoVenta>>() {
                @Override
                public void finish(List<PuntoVenta> resultado) {
                    listenerView.finish(resultado);
                }
            });
        }
    }
}
