package com.recycler.agendacontactos.presenters;

import android.content.Context;
import android.widget.Toast;

import com.recycler.agendacontactos.db.ConstructorContactos;
import com.recycler.agendacontactos.models.Contacto;
import com.recycler.agendacontactos.views.IContactosFragment;

import java.util.ArrayList;

public class ContactosFragmentPresenter implements IContactosFragmentPresenter {

    private IContactosFragment iContactosFragment;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;

    public ContactosFragmentPresenter(IContactosFragment iContactosFragment, Context context) {
        this.iContactosFragment = iContactosFragment;
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
        iContactosFragment.inicializarAdapter(iContactosFragment.crearAdapter(contactos));
        iContactosFragment.generarLinearLayoutVertical();
    }

    @Override
    public void guardarContacto(Contacto contacto) {
        constructorContactos = new ConstructorContactos(context);
        constructorContactos.insertarContactos(contacto);
    }
}
