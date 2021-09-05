package com.recycler.agendacontactos.views.mostrar;

public interface IMostrarContactoFragment {

    void mensajeSuccess(String mensaje);
    void mensajeError(String mensaje);
    void mostrarContacto(String nombre, String telefono, String correo, String direccion, String profesion, String imagen);
    void alertEliminarContacto(int id);
}
