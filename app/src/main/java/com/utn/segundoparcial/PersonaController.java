package com.utn.segundoparcial;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import java.util.ArrayList;

public class PersonaController {
    public MainActivity activity;
    public Gson converter;

    public PersonaController(MainActivity activity) {
        this.activity = activity;
        this.converter= new Gson();
    }

    public ArrayList<Persona> agregarContacto(Persona p){
        String contactos = this.activity.prefs.getString("personaNueva","[]");

        Persona[] listaContactos = converter.fromJson(contactos, Persona[].class);
        ArrayList<Persona> list = new ArrayList<Persona>();
        for (int i = 0 ; i < listaContactos.length; i++){
            list.add(listaContactos[i]);
        }
        list.add(p);

        SharedPreferences.Editor edit = this.activity.prefs.edit();
        edit.putString("personaNueva" ,converter.toJson(list));
        edit.commit();
        return list;
    }

    public Persona buscarPersona(String nombre){
        Persona p = null;
        String contactos = this.activity.prefs.getString("personaNueva","[]");
        Persona[] listaContactos = converter.fromJson(contactos, Persona[].class);
        for (Persona contacto :listaContactos) {
            if(contacto.getNombre().toLowerCase().equals(nombre.toLowerCase())){
                p= contacto;
            }
        }
        return p;
    }

    public Boolean esValidaPersona( Persona p ){
        if(p.getNombre().equals("") || p.getTelefono().equals("")){
            return false;
        }
        return true;
    }
}
