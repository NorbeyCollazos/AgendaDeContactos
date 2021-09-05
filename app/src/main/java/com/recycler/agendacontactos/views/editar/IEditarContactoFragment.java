package com.recycler.agendacontactos.views.editar;

public interface IEditarContactoFragment {

    void mensajeError(String mensaje);
    void mensajeSuccess(String mensaje);
    void mensajeEditado(String mensaje);
    void mostrarContacto(String nombre, String telefono, String correo, String direccion, String profesion, String imagen);
}
