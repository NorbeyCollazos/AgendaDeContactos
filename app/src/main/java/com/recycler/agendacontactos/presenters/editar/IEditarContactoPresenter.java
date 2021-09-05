package com.recycler.agendacontactos.presenters.editar;

public interface IEditarContactoPresenter {

    void mostrarContacto(int id);
    void editarContacto(int id, String nombre, String telefono, String correo);

}
