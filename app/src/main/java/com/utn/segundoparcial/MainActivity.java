package com.utn.segundoparcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SharedPreferences prefs;
    PersonaController personaController;
    PersonaView personaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.personaController = new PersonaController(this);
        this.personaView = new PersonaView(this);
        this.prefs= getSharedPreferences("personas", Context.MODE_PRIVATE);
        personaView.actualizaContactos();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem = menu.findItem(R.id.opSearch);
        SearchView sv =(SearchView) menuItem.getActionView();
        sv.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if( item.getItemId()== R.id.agregarPersona){
            DialogPersonalizado dialog = new DialogPersonalizado("Nuevo Contacto", this);
            dialog.show(getSupportFragmentManager(),"");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Persona result = this.personaController.buscarPersona(query);
        if (result == null){
            DialogGenerico dialog = new DialogGenerico("No Encontrada", "La persona que busco no esta dentro de la lista");
            dialog.show(getSupportFragmentManager(),"No encontrada");
        }else{
            this.personaView.mostrarContacto(result);
        }
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {


        return false;
    }
}

