package com.recycler.agendacontactos.presenters.listar;

import android.content.Context;

import com.recycler.agendacontactos.db.ConstructorContactos;
import com.recycler.agendacontactos.models.Contacto;
import com.recycler.agendacontactos.views.listar.IListaContactosFragment;

import java.util.ArrayList;

public class ListaContactosFragmentPresenter implements IListaContactosFragmentPresenter {

    private IListaContactosFragment iListaContactosFragment;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;

    public ListaContactosFragmentPresenter(IListaContactosFragment iListaContactosFragment, Context context) {
        this.iListaContactosFragment = iListaContactosFragment;
        this.context = context;
        obtenerContactos();
    }

    @Override
    public void obtenerContactos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iListaContactosFragment.inicializarAdapter(iListaContactosFragment.crearAdapter(contactos));
        iListaContactosFragment.generarLinearLayoutVertical();
    }

}
