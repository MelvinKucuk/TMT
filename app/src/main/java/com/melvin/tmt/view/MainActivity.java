package com.melvin.tmt.view;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.melvin.tmt.R;

public class MainActivity extends AppCompatActivity implements FragmentListado.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentListado fragment = new FragmentListado();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();

    }

    @Override
    public void elementoSeleccionado(String nombre, String direccion, String ciudad, String latitud, String longitud) {
        Bundle datos = new Bundle();
        datos.putString(FragmentDetalles.KEY_NOMBRE, nombre);
        datos.putString(FragmentDetalles.KEY_DIRECCION, direccion);
        datos.putString(FragmentDetalles.KEY_CIUDAD, ciudad);
        datos.putString(FragmentDetalles.KEY_LATITUD, latitud);
        datos.putString(FragmentDetalles.KEY_LONGITUD, longitud);
        FragmentDetalles fragment = new FragmentDetalles();
        fragment.setArguments(datos);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).addToBackStack(null).commit();
    }
}
