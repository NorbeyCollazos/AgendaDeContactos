package com.recycler.agendacontactos.db;

import android.content.ContentValues;
import android.content.Context;
import android.widget.Toast;

import com.recycler.agendacontactos.models.Contacto;

import java.util.ArrayList;

public class ConstructorContactos {

    Context context;

    public ConstructorContactos(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerTodosLosContactos();
    }

    public void insertarContactos(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantsDB.TABLE_CONTACTS_NAME, contacto.getNombre());
        contentValues.put(ConstantsDB.TABLE_CONTACTS_PHONE,contacto.getTelefono());
        contentValues.put(ConstantsDB.TABLE_CONTACTS_EMAIL,contacto.getCorreo());

        db.insertarContacto(contentValues);

        Toast.makeText(context, "Contacto registrado", Toast.LENGTH_SHORT).show();
        obtenerDatos();

    }
}
