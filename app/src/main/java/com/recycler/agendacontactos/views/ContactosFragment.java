package com.recycler.agendacontactos.views;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.recycler.agendacontactos.R;
import com.recycler.agendacontactos.adapters.ContactoAdapter;
import com.recycler.agendacontactos.models.Contacto;
import com.recycler.agendacontactos.presenters.ContactosFragmentPresenter;
import com.recycler.agendacontactos.presenters.IContactosFragmentPresenter;

import java.util.ArrayList;

public class ContactosFragment extends Fragment implements IContactosFragment{

    private RecyclerView recyclerViewContactos;
    private ContactoAdapter adapter;
    private IContactosFragmentPresenter presenter;

    private ArrayList<Contacto> contactos;

    public ContactosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);//para habilitar el menu
        return inflater.inflate(R.layout.fragment_contactos, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewContactos = view.findViewById(R.id.recyclerViewContactos);
        presenter = new ContactosFragmentPresenter(this, getContext());

        //formularioContacto();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add: {
                formularioContacto();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewContactos.setLayoutManager(linearLayoutManager);
    }

    @Override
    public ContactoAdapter crearAdapter(ArrayList<Contacto> contactos) {
        adapter = new ContactoAdapter(contactos, getActivity());
        return adapter;
    }

    @Override
    public void inicializarAdapter(ContactoAdapter adapter) {
        recyclerViewContactos.setAdapter(adapter);
    }

    @Override
    public void formularioContacto() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.form_contacto, null);
        builder.setView(view);

        final AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);

        final EditText etNombre = view.findViewById(R.id.etNombre);
        final EditText etTelefono = view.findViewById(R.id.etTelefono);
        final EditText etCorreo = view.findViewById(R.id.etCorreo);

        final Button btnRegistrarContacto = view.findViewById(R.id.btnRegistrarContacto);
        btnRegistrarContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = etNombre.getText().toString().trim();
                String telefono = etTelefono.getText().toString().trim();
                String correo = etCorreo.getText().toString().trim();

                enviarDatosContacto(nombre,telefono,correo);
            }
        });


        dialog.show();
    }

    @Override
    public void enviarDatosContacto(String nombre, String telefono, String correo) {
        Contacto contacto = new Contacto();
        contacto.setNombre(nombre);
        contacto.setCorreo(correo);
        contacto.setTelefono(telefono);
        presenter.guardarContacto(contacto);
    }


}