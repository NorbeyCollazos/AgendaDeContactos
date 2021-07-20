package com.recycler.agendacontactos.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        return inflater.inflate(R.layout.fragment_contactos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewContactos = view.findViewById(R.id.recyclerViewContactos);
        presenter = new ContactosFragmentPresenter(this, getContext());

        //llenarDatos();
    }

    private void llenarDatos() {
        contactos = new ArrayList<>();
        contactos.add(new Contacto(1,"Norbey","3208274742","correo"));
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
}