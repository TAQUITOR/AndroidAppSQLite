package com.example.sqlite.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite.R;
import com.example.sqlite.entidades.Usuarios;

import java.util.ArrayList;

public class ListaUsuarioAdapter extends RecyclerView.Adapter<ListaUsuarioAdapter.UsuarioViewHolder> {

    ArrayList<Usuarios> listaUsuarios;

    public ListaUsuarioAdapter(ArrayList<Usuarios> listaUsuarios){
        this.listaUsuarios = listaUsuarios;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_usuarios,null, false);
        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        holder.viewID.setText(String.valueOf(listaUsuarios.get(position).getId()));
        holder.viewNombre.setText(listaUsuarios.get(position).getNombre());
        holder.viewApaterno.setText(listaUsuarios.get(position).getA_paterno());
        holder.viewAmaterno.setText(listaUsuarios.get(position).getA_materno());
        holder.viewCurp.setText(listaUsuarios.get(position).getCurp());
        holder.viewEdad.setText(listaUsuarios.get(position).getEdad());
        holder.viewGenero.setText(listaUsuarios.get(position).getGenero());
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public class UsuarioViewHolder extends RecyclerView.ViewHolder {

        TextView viewID,viewNombre,viewApaterno, viewAmaterno, viewCurp, viewEdad, viewGenero;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);


            viewID = itemView.findViewById(R.id.viewID);
            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewApaterno = itemView.findViewById(R.id.viewApaterno);
            viewAmaterno = itemView.findViewById(R.id.viewAmaterno);
            viewCurp = itemView.findViewById(R.id.viewCurp);
            viewEdad = itemView.findViewById(R.id.viewEdad);
            viewGenero = itemView.findViewById(R.id.viewGenero);



        }
    }
}
