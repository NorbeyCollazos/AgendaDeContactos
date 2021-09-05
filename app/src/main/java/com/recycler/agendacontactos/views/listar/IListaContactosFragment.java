package com.recycler.agendacontactos.views.listar;

import com.recycler.agendacontactos.adapters.ContactoAdapter;
import com.recycler.agendacontactos.models.Contacto;

import java.util.ArrayList;

public interface IListaContactosFragment {

    void generarLinearLayoutVertical();

    ContactoAdapter crearAdapter(ArrayList<Contacto> contactos);

    void inicializarAdapter(ContactoAdapter adapter);

}
