package com.recycler.agendacontactos.presenters.mostrar;

import android.content.Context;

import com.recycler.agendacontactos.db.ConstructorContactos;
import com.recycler.agendacontactos.models.Contacto;
import com.recycler.agendacontactos.views.mostrar.IMostrarContactoFragment;

public class MostrarContactoPresenter implements IMostrarContactoPresenter {

    IMostrarContactoFragment view;
    Context context;
    private ConstructorContactos constructorContactos;

    public MostrarContactoPresenter(IMostrarContactoFragment view, Context context) {
        this.view = view;
        this.context = context;
        constructorContactos = new ConstructorContactos(context);
    }

    @Override
    public void mostrarContacto(int id) {
        Contacto contacto = constructorContactos.obtenerContacto(id);
        view.mostrarContacto(
            contacto.getNombre(),
                contacto.getTelefono(),
                contacto.getCorreo(),
                null,
                null,
                null
        );
    }

    @Override
    public void eliminarContacto(int id) {
        if (constructorContactos.eliminarContacto(id) > 0){
            view.mensajeSuccess("Se eliminó el contacto");
        }else {
            view.mensajeError("No se pudo eliminar");
        }
    }
}
