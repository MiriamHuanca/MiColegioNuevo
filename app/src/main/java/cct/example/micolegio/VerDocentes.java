 package cct.example.micolegio;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class VerDocentes extends android.support.v4.app.Fragment {
    ListView listView ;
    private DBManager dbManager;
    private SimpleCursorAdapter adapter;

    //ListView lv ;
    //String[] DocentesRegistrados={"docenteRegistrado 1","docenteRegistrado 2","docenteRegistrado 3","docenteRegistrado 4","docenteRegistrado 5"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ver_docentes, container, false);
    }
/*
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       // lv = (ListView) getView().findViewById(R.id.lvDocentes);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_expandable_list_item_1, DocentesRegistrados);
        lv.setAdapter(adaptador);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getActivity().getApplicationContext(), "Aqui ira el menu para eliminar , asistencia y perfil", Toast.LENGTH_LONG).show();
            }
        });
    }*/

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            dbManager = new DBManager(getActivity());
            dbManager.open();
            Cursor cursor1 = dbManager.fetchPro();
            ArrayList<String> teachers = new ArrayList<>();

            String name_lastname;
            if((cursor1.getCount() >0)){

                name_lastname= cursor1.getString(1)+" "+cursor1.getString(2);
                teachers.add(name_lastname);
            }
            while(cursor1.moveToNext()){
                name_lastname= cursor1.getString(1)+" "+cursor1.getString(2);
                teachers.add(name_lastname);
            }
            //System.out.println(cursor.getString(1));
            listView=(ListView) getView().findViewById(R.id.lvDocentes);

            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_expandable_list_item_1, teachers);
            listView.setAdapter(adaptador);
            dbManager.close();
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    // IR A OTRO FRAGMENTO
                    //getFragmentManager().beginTransaction().replace(R.id.action_logout,new AsistenciaProf()).addToBackStack(null).commit();
                    Toast.makeText(getActivity().getApplicationContext(),"Aqui esta asistencia del docente",Toast.LENGTH_LONG).show();
                }
            });
        }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            dbManager = new DBManager(getActivity());
            dbManager.open();
            Cursor cursor = dbManager.fetchPro();
            ArrayList<String> teachers = new ArrayList<>();
            String name_lastname;
            if((cursor.getCount() >0)){

                name_lastname= cursor.getString(1)+" "+cursor.getString(2);
                teachers.add(name_lastname);
            }
            while(cursor.moveToNext()){
                name_lastname= cursor.getString(1)+" "+cursor.getString(2);
                teachers.add(name_lastname);
            }
            dbManager.close();
            //System.out.println(cursor.getString(1));
            listView = (ListView) getView().findViewById(R.id.lvDocentes);

            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_expandable_list_item_1, teachers);
            listView.setAdapter(adaptador);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    Toast.makeText(getActivity().getApplicationContext(),"Aqui esta docente",Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}