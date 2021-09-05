package com.recycler.agendacontactos.presenters;

import com.recycler.agendacontactos.models.Contacto;

public interface IContactosFragmentPresenter {

    public void obtenerContactos();

    public void mostrarContactosRV();

    public void guardarContacto(Contacto contacto);
}
