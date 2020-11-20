package com.utn.segundoparcial;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Persona {
    public String nombre;
    public String telefono;

    public Persona() {
    }

    public Persona(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return ((Persona)obj).nombre.equals(this.nombre);
    }

    @NonNull
    @Override
    public String toString() {
        return this.nombre + " " + this.telefono;
    }
}
