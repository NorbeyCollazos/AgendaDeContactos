package com.recycler.agendacontactos.views.listar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.recycler.agendacontactos.R;
import com.recycler.agendacontactos.adapters.ContactoAdapter;
import com.recycler.agendacontactos.models.Contacto;
import com.recycler.agendacontactos.presenters.listar.ListaContactosFragmentPresenter;
import com.recycler.agendacontactos.presenters.listar.IListaContactosFragmentPresenter;

import java.util.ArrayList;

public class ListaContactosFragment extends Fragment implements IListaContactosFragment {

    private RecyclerView recyclerViewContactos;
    private ContactoAdapter adapter;
    private IListaContactosFragmentPresenter presenter;

    private FloatingActionButton floatingAdd;

    public ListaContactosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);//para habilitar el menu
        return inflater.inflate(R.layout.fragment_lista_contactos, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewContactos = view.findViewById(R.id.recyclerViewContactos);
        presenter = new ListaContactosFragmentPresenter(this, getContext());

        floatingAdd = view.findViewById(R.id.floatingAdd);
        floatingAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.agregarContactoFragment);
            }
        });

    }

    /*@Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add: {
                formularioContacto();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

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