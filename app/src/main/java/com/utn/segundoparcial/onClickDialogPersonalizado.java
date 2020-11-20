package com.utn.segundoparcial;

import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;


public class onClickDialogPersonalizado implements DialogInterface.OnClickListener {

    public View viewAlert;
    public MainActivity activity;

    public onClickDialogPersonalizado(View viewAlert, MainActivity activity){
        this.viewAlert = viewAlert;
        this.activity = activity;
    }
    @Override
    public void onClick(DialogInterface dialog, int which) {
        PersonaController personasControler = new PersonaController(this.activity);
        PersonaView personaView = new PersonaView(this.activity);

        EditText nombre = this.viewAlert.findViewById(R.id.nombre);
        EditText telefono = this.viewAlert.findViewById(R.id.telefono);

        Persona p = new Persona( nombre.getText().toString(),telefono.getText().toString() );
        if (personasControler.esValidaPersona(p)){
            personasControler.agregarContacto(p);
            personaView.actualizaContactos();
        }else{
            DialogGenerico dialogError = new DialogGenerico("Error", "Deber cargar todos los datos");
            dialogError.show(this.activity.getSupportFragmentManager(),"Error");
        }

        dialog.dismiss();




    }
}
