package com.recycler.agendacontactos.db;

import android.content.ContentValues;
import android.content.Context;

import com.recycler.agendacontactos.models.Contacto;

import java.util.ArrayList;

public class ConstructorContactos {

    Context context;

    public ConstructorContactos(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos(){
        /*ArrayList<Contacto> contactos = new ArrayList<>();
        contactos.add(new Contacto(1,"Norbey","3208274742","correo"));
        return contactos;*/

        BaseDatos db = new BaseDatos(context);
        insertarContactos(db);
        return db.obtenerTodosLosContactos();
    }

    public void insertarContactos(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantsDB.TABLE_CONTACTS_NAME,"Norbey collazos");
        contentValues.put(ConstantsDB.TABLE_CONTACTS_PHONE,"3208274742");
        contentValues.put(ConstantsDB.TABLE_CONTACTS_EMAIL,"ncrcollazos@gmail.com");

        db.insertarContacto(contentValues);

    }
}
