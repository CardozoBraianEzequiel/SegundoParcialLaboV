package com.utn.segundoparcial;

import android.widget.TextView;

public class PersonaView {

    public MainActivity activity;
    public TextView contacts;

    public PersonaView(MainActivity activity ) {
        this.activity = activity;
        this.contacts = this.activity.findViewById(R.id.tvPrincipal);
    }

    public void actualizaContactos(){
        String contactos = this.activity.prefs.getString("personaNueva","[]");
        contacts.setText(contactos);
    }

    public void mostrarContacto( Persona p){
        DialogGenerico dialog = new DialogGenerico("Persona Encontrada", "El telefono es" + " " + p.getTelefono());
        dialog.show(this.activity.getSupportFragmentManager(),"Persona Encontrada");
    }
}
