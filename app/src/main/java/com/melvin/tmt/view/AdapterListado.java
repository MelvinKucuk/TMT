package com.melvin.tmt.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.melvin.tmt.R;
import com.melvin.tmt.model.PuntoVenta;

import java.util.ArrayList;
import java.util.List;

public class AdapterListado extends RecyclerView.Adapter {

    private List<PuntoVenta> datos;
    private AdapterInterface listener;

    public AdapterListado(List<PuntoVenta> datos, AdapterInterface listener) {
        this.datos = datos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.layout_item_punto_venta, viewGroup, false);
        ViewHolderListado viewHolder = new ViewHolderListado(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ViewHolderListado) viewHolder).cargar(datos.get(i));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    private class ViewHolderListado extends RecyclerView.ViewHolder{

        private TextView nombre;
        private TextView direccion;

        public ViewHolderListado(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.textoNombre);
            direccion = itemView.findViewById(R.id.textoDireccion);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PuntoVenta dato = datos.get(getAdapterPosition());
                    listener.elementoSeleccionado(dato.getName(), dato.getAddress(), dato.getCity().getName(), dato.getLatitude(), dato.getLongitude());
                }
            });
        }

        public void cargar(PuntoVenta puntoVenta){
            nombre.setText(puntoVenta.getName());
            direccion.setText(puntoVenta.getAddress());
        }
    }

    public interface AdapterInterface{
        void elementoSeleccionado(String nombre, String direccion, String ciudad, String latitud, String longitud);
    }

    public void setDatos(List<PuntoVenta> datos) {
        this.datos = datos;
        ordenarAlfabeticamente(datos);
        notifyDataSetChanged();
    }

    private List<PuntoVenta> ordenarAlfabeticamente(List<PuntoVenta> datos){

        PuntoVenta aux;

        for (int i = 0; i <datos.size(); i++){
            for (int j = i+1; j< datos.size(); j++){
                if (datos.get(i).getName().toLowerCase().compareTo(datos.get(j).getName().toLowerCase()) > 0){

                    aux = datos.get(i);
                    datos.set(i, datos.get(j));
                    datos.set(j, aux);
                }
            }
        }
        return datos;
    }
}
