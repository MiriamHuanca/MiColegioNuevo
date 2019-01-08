package cct.example.micolegio;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class AsistenciaEstu extends android.support.v4.app.Fragment{

    ListView listView ;
    private DBManager dbManager;
    private SimpleCursorAdapter adapter;
    TextView item;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_asistencia_estu, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        dbManager = new DBManager(getActivity());
        dbManager.open();
        Cursor cursor = dbManager.fetch();
        ArrayList<String> students = new ArrayList<>();

        String name_lastname;
        if((cursor.getCount() >0)){

            name_lastname= cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2);
            students.add(name_lastname);
        }
        while(cursor.moveToNext()){
            name_lastname= cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2);
            students.add(name_lastname);
        }
        //System.out.println(cursor.getString(1));
        listView = (ListView) getView().findViewById(R.id.lvListarEstudiantes);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_expandable_list_item_1, students);
        listView.setAdapter(adaptador);
        dbManager.close();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // IR A OTRO FRAGMENTO
                //getFragmentManager().beginTransaction().replace(R.id.action_logout, new RegistroAlumnoFragment()).addToBackStack(null).commit();



                item = (TextView)view.findViewById(android.R.id.text1);
                String nombre= item.getText().toString();

                String []ci= nombre.split(" ");

                /*Intent intent = new Intent(getActivity().getApplicationContext(),ActivityDirector.class);
                intent.putExtra()*/

                Toast.makeText(getActivity().getApplicationContext(),"nombre1:"+ci[0],Toast.LENGTH_LONG).show();
                //getFragmentManager().beginTransaction().replace(R.id.action_logout,new EditarAsistenciaEstudiante()).addToBackStack(null).commit();
            }
        });

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            dbManager = new DBManager(getActivity());
            dbManager.open();
            Cursor cursor = dbManager.fetch();
            ArrayList<String> students = new ArrayList<>();
            String name_lastname;
            if((cursor.getCount() >0)){

                name_lastname= cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2);
                students.add(name_lastname);
            }
            while(cursor.moveToNext()){
                name_lastname= cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2);
                students.add(name_lastname);
            }
            //System.out.println(cursor.getString(1));
            listView = (ListView) getView().findViewById(R.id.lvListarEstudiantes);

            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_expandable_list_item_1, students);
            listView.setAdapter(adaptador);
            dbManager.close();
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    item = (TextView)view.findViewById(android.R.id.text1);
                    String nombre= item.getText().toString();

                    String []ci= nombre.split(" ");
                    Toast.makeText(getActivity().getApplicationContext(),"nombre2:"+ci[0],Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
