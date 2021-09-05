package com.recycler.agendacontactos.views.agregar;

public interface IAgregarContactoFragment {

    void mensajeError(String mensaje);
    void mensajeSuccess(String mensaje);
    void mensajeRegistrado(String mensaje);
    void limpiarCampos();
}
