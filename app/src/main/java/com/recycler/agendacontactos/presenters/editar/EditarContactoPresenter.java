package com.recycler.agendacontactos.presenters.editar;

import android.content.Context;

import com.recycler.agendacontactos.db.ConstructorContactos;
import com.recycler.agendacontactos.models.Contacto;
import com.recycler.agendacontactos.views.editar.IEditarContactoFragment;

public class EditarContactoPresenter implements IEditarContactoPresenter {

    IEditarContactoFragment view;
    Context context;
    ConstructorContactos constructorContactos;

    public EditarContactoPresenter(IEditarContactoFragment view, Context context) {
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
    public void editarContacto(int id, String nombre, String telefono, String correo) {
        long result = 0;
        constructorContactos = new ConstructorContactos(context);
        Contacto contacto = new Contacto();
        contacto.setId(id);
        contacto.setNombre(nombre);
        contacto.setTelefono(telefono);
        contacto.setCorreo(correo);
        result = constructorContactos.editarContacto(id, contacto);

        if (result > 0 ){
            view.mensajeSuccess("Se ha registrado un nuevo contacto");
        }else{
            view.mensajeError("No se ha podido registrar");
        }
    }


}
