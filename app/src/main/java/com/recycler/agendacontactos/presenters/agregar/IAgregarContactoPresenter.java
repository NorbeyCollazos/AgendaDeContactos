package com.recycler.agendacontactos.presenters.agregar;

public interface IAgregarContactoPresenter {

    void registrarContacto(String nombre, String telefono, String correo, String direccion, String profesion, String imagen);
}
