package cct.example.micolegio;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AutoText;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtNombre;
    EditText edtContrasena;

    Button btnIngresar;
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtContrasena = (EditText) findViewById(R.id.edtContraseña);

        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        dbManager= new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.exitsDirector("654321");
        if(!(cursor.getCount()==1)){
            dbManager.insertPro("654321","Reynaldo","Suleta Mamani","Masculino","19/10/1977","reynaldo@yahoo.es","70616902","Matemáticas","Z.Villa Adela,Calle Luces,No.2341","director");
        }
        dbManager.close();
    }



    public  void  ingresar(View view){
        //String nom = edtNombre.getText().toString();
        String ci = edtContrasena.getText().toString();
        dbManager=new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetchType(ci);
        if(cursor.getCount()>0){
            Intent intent = new Intent(getApplicationContext(),ActivityEstudiante.class);
            intent.putExtra("ci",ci);
            startActivity(intent);
        }
        else{
            Cursor cursorP = dbManager.fetchTypeDocente(ci);
            if(cursorP.getCount()>0){
                Log.wtf("typo docente",cursorP.getString(0) );
                if(cursorP.getString(0).equals("profesor")){

                    Intent intent = new Intent(getApplicationContext(),ActivityProfesor.class);
                    intent.putExtra("ci",ci);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(getApplicationContext(),ActivityDirector.class);
                    intent.putExtra("ci",ci);
                    startActivity(intent);

                }
            }

        }
        dbManager.close();
        /*String tipo = cursor.getString(0);
        Log.wtf("tipooooooooo: ",tipo);
        dbManager.close();

       *//* String tipo = cursor.getString(9);
        Log.wtf("tipo:",tipo);*//*
            *//*if(tipo =="profesor"){
                Intent intent = new Intent(getApplicationContext(),ActivityProfesor.class);
                startActivity(intent);
            }*//*
        if (nom.equals("profesor")){
            Intent intent = new Intent(getApplicationContext(),ActivityProfesor.class);
            startActivity(intent);

            dbManager= new DBManager(this);
            // Log.wtf("ci:",nom);



        }
        if (nom.equals("estudiante")){
            Intent intent = new Intent(getApplicationContext(),ActivityEstudiante.class);
                    //intent.putExtra(student_id);
           *//* String nombre="Miriam";

            Bundle bolsa=new Bundle();
            bolsa.putString("valor",nombre);
            intent.putExtras(bolsa);
*//*
            startActivity(intent);
        }
        if(nom.equals("director")){
            Intent intent = new Intent(getApplicationContext(),ActivityDirector.class);
            startActivity(intent);
        }
*/

    }
}
