package com.recycler.agendacontactos.presenters.agregar;

import android.content.Context;

import com.recycler.agendacontactos.db.ConstructorContactos;
import com.recycler.agendacontactos.models.Contacto;
import com.recycler.agendacontactos.views.agregar.IAgregarContactoFragment;

public class AgregarContactoPresenter implements IAgregarContactoPresenter{

    private IAgregarContactoFragment view;
    private Context context;
    private ConstructorContactos constructorContactos;

    public AgregarContactoPresenter(IAgregarContactoFragment view, Context context) {
        this.view = view;
        this.context = context;
        constructorContactos = new ConstructorContactos(context);
    }

    @Override
    public void registrarContacto(String nombre, String telefono, String correo, String direccion, String profesion, String imagen) {
        long result = 0;
        constructorContactos = new ConstructorContactos(context);
        Contacto contacto = new Contacto();
        contacto.setNombre(nombre);
        contacto.setTelefono(telefono);
        contacto.setCorreo(correo);
        result = constructorContactos.insertarContactos(contacto);

        if (result > 0 ){
            view.mensajeRegistrado("Se ha registrado un nuevo contacto");
            view.limpiarCampos();
        }else{
            view.mensajeError("No se ha podido registrar");
        }
    }
}
