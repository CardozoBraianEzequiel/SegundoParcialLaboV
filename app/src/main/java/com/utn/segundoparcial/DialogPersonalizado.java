package com.utn.segundoparcial;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogPersonalizado extends DialogFragment {

    public String titulo;
    public MainActivity activity;

    public DialogPersonalizado(String titulo, MainActivity activity){
        this.titulo = titulo;
        this.activity=activity;
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        LayoutInflater li =LayoutInflater.from(getActivity());
        View viewAlert = li.inflate(R.layout.alta_persona,null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(this.titulo);

        onClickDialogPersonalizado onClickAddDialog = new onClickDialogPersonalizado( viewAlert, this.activity );
        builder.setView(viewAlert);
        builder.setNeutralButton("Cancelar",null);
        builder.setPositiveButton("Guardar",onClickAddDialog);
        return builder.create();


    }
}
