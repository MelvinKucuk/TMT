package com.melvin.tmt.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.melvin.tmt.R;
import com.melvin.tmt.controller.ControllerPuntoVenta;
import com.melvin.tmt.model.PuntoVenta;
import com.melvin.tmt.util.ResultListener;

import java.util.ArrayList;
import java.util.List;


public class FragmentListado extends Fragment implements AdapterListado.AdapterInterface{

    private OnFragmentInteractionListener mListener;
    private List<PuntoVenta> datos = new ArrayList<>();
    private AdapterListado adapter;

    public FragmentListado() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_listado, container, false);

        new ControllerPuntoVenta().obtenerPuntoVenta(getContext(), new ResultListener<List<PuntoVenta>>() {
            @Override
            public void finish(List<PuntoVenta> resultado) {
                datos = resultado;
                adapter.setDatos(datos);
            }
        });

        RecyclerView recycler = view.findViewById(R.id.recyclerListado);
        adapter = new AdapterListado(datos, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(layoutManager);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void elementoSeleccionado(String nombre, String direccion, String ciudad, String latitud, String longitud);
    }

    @Override
    public void elementoSeleccionado(String nombre, String direccion, String ciudad, String latitud, String longitud) {
        mListener.elementoSeleccionado(nombre, direccion, ciudad, latitud, longitud);
    }
}
