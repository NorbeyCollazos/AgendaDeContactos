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

    public long insertarContactos(Contacto contacto){
        long result = 0;
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantsDB.TABLE_CONTACTS_NAME, contacto.getNombre());
        contentValues.put(ConstantsDB.TABLE_CONTACTS_PHONE,contacto.getTelefono());
        contentValues.put(ConstantsDB.TABLE_CONTACTS_EMAIL,contacto.getCorreo());

        result = db.insertarContacto(contentValues);

        return result;

    }


    public Contacto obtenerContacto(int id){
        BaseDatos db = new BaseDatos(context);
        return db.consultarContacto(id);
    }

    public long editarContacto(int id, Contacto contacto){
        long result = 0;
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantsDB.TABLE_CONTACTS_NAME, contacto.getNombre());
        contentValues.put(ConstantsDB.TABLE_CONTACTS_PHONE,contacto.getTelefono());
        contentValues.put(ConstantsDB.TABLE_CONTACTS_EMAIL,contacto.getCorreo());

        result = db.editarContacto(id, contentValues);

        return result;

    }

    public long eliminarContacto(int id){
        long result = 0;
        BaseDatos db = new BaseDatos(context);
        result = db.eliminarContacto(id);
        return result;
    }


}
