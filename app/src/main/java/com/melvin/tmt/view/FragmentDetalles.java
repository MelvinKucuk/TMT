package com.melvin.tmt.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.melvin.tmt.R;


public class FragmentDetalles extends Fragment {

    public static final String KEY_NOMBRE = "nombre";
    public static final String KEY_DIRECCION = "direccion";
    public static final String KEY_CIUDAD = "ciudad";
    public static final String KEY_LATITUD = "latitud";
    public static final String KEY_LONGITUD = "longitud";

    public FragmentDetalles() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_detalles, container, false);

        Bundle datos = getArguments();

        TextView viewNombre = view.findViewById(R.id.textoNombreDetalle);
        TextView viewDireccion = view.findViewById(R.id.textoDireccionDetalle);
        TextView viewCiudad = view.findViewById(R.id.textoCiudadDetalle);
        TextView viewLongitud = view.findViewById(R.id.textoLongitudDetalle);
        TextView viewLatitud = view.findViewById(R.id.textoLatitudDetalle);

        viewNombre.setText(datos.getString(KEY_NOMBRE));
        viewDireccion.setText(datos.getString(KEY_DIRECCION));
        viewCiudad.setText(datos.getString(KEY_CIUDAD));
        viewLatitud.setText(datos.getString(KEY_LATITUD));
        viewLongitud.setText(datos.getString(KEY_LONGITUD));

        return view;
    }




}
