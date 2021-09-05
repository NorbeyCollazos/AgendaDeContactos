package com.recycler.agendacontactos.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;

import androidx.annotation.Nullable;

import com.recycler.agendacontactos.models.Contacto;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, ConstantsDB.DATABASE_NAME, null, ConstantsDB.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCrearTableContacts = "CREATE TABLE " + ConstantsDB.TABLE_CONTACTS + "("+
                ConstantsDB.TABLE_CONTACTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantsDB.TABLE_CONTACTS_NAME + " TEXT, " +
                ConstantsDB.TABLE_CONTACTS_PHONE + " TEXT, " +
                ConstantsDB.TABLE_CONTACTS_EMAIL + " TEXT " +
                ")";
        sqLiteDatabase.execSQL(queryCrearTableContacts);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.TABLE_CONTACTS);
    }

    public ArrayList<Contacto> obtenerTodosLosContactos(){
        ArrayList<Contacto> contactos = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantsDB.TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while (registros.moveToNext()){
            Contacto contactoActual = new Contacto();
            contactoActual.setId(registros.getInt(0));
            contactoActual.setNombre(registros.getString(1));
            contactoActual.setTelefono(registros.getString(2));
            contactoActual.setCorreo(registros.getString(3));

            contactos.add(contactoActual);
        }

        db.close();

        return contactos;
    }

    public long insertarContacto(ContentValues contentValues){
        long result = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        result = db.insert(ConstantsDB.TABLE_CONTACTS, null, contentValues);
        db.close();

        return result;
    }

    public Contacto consultarContacto(int id){

        String query = "SELECT * FROM " + ConstantsDB.TABLE_CONTACTS + " WHERE "+ConstantsDB.TABLE_CONTACTS_ID+" = "+id;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        Contacto contacto = new Contacto();
        if (registros.moveToFirst()){
            contacto.setNombre(registros.getString(1));
            contacto.setTelefono(registros.getString(2));
            contacto.setCorreo(registros.getString(3));
        }

        return contacto;

    }

    public long editarContacto(final int id, ContentValues contentValues){
        long result = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        //result = db.insert(ConstantsDB.TABLE_CONTACTS, null, contentValues);
        result = db.update(ConstantsDB.TABLE_CONTACTS, contentValues, ConstantsDB.TABLE_CONTACTS_ID +" = "+id, null);
        db.close();

        return result;
    }

    public long eliminarContacto(int id){
        long result = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        result = db.delete(ConstantsDB.TABLE_CONTACTS, ConstantsDB.TABLE_CONTACTS_ID+ " = "+ id, null);

        return result;
    }
}
