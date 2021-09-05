package com.recycler.agendacontactos.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.recycler.agendacontactos.R;
import com.recycler.agendacontactos.models.Contacto;

import java.util.ArrayList;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.contactoViewHolder> {

    ArrayList<Contacto> contactos;
    Context context;

    public ContactoAdapter(ArrayList<Contacto> contactos, Context context) {
        this.contactos = contactos;
        this.context = context;
    }

    @NonNull
    @Override
    public contactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_contacto, parent, false);
        return new contactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull contactoViewHolder holder, int position) {
        final Contacto contacto = contactos.get(position);
        holder.tvnombre.setText(contacto.getNombre());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("id", contacto.getId());
                Navigation.findNavController(view).navigate(R.id.mostrarContactoFragment, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public class contactoViewHolder extends RecyclerView.ViewHolder {

        private TextView tvnombre;
        private View view;

        public contactoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvnombre = itemView.findViewById(R.id.tvNombre);
            view = itemView;
        }
    }
}
