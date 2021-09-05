package com.recycler.agendacontactos.views;

import com.recycler.agendacontactos.adapters.ContactoAdapter;
import com.recycler.agendacontactos.models.Contacto;
import com.recycler.agendacontactos.presenters.ContactosFragmentPresenter;
import com.recycler.agendacontactos.presenters.IContactosFragmentPresenter;

import java.util.ArrayList;

public interface IContactosFragment {

    public void generarLinearLayoutVertical();

    public ContactoAdapter crearAdapter(ArrayList<Contacto> contactos);

    public void inicializarAdapter(ContactoAdapter adapter);

    public void formularioContacto();

    public void enviarDatosContacto(String nombre, String telefono, String correo);

}
