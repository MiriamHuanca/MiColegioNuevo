package cct.example.micolegio;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class PerfilE extends android.support.v4.app.Fragment {

    private DBManager dbManager;
    private SimpleCursorAdapter adapter;

    private TextView tv;
    private TextView grad;
    private TextView para;
    private TextView nam;
    private TextView surnam;
    private TextView gener;
    private TextView fe_nac;
    private TextView nacio;
    private TextView domi;
    private TextView cit;
    private TextView nomt;
    private TextView dirt;
    private TextView telt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil_e, container, false);
        // Inflate the layout for this fragment
        Intent intent = getActivity().getIntent();
        tv=(TextView) view.findViewById(R.id.mo_ci_e);
        String ci_est=intent.getStringExtra("ci");
        //consulta para obetener segun este ci
        dbManager=new DBManager(getActivity());
        dbManager.open();
        Cursor cursor = dbManager.fetchConsulEst(ci_est);

        String grade=cursor.getString(6);
        String parallel=cursor.getString(7);
        String name_= cursor.getString(1);
        String surname=cursor.getString(2);
        String genero=cursor.getString(3);
        String fec_nac=cursor.getString(5);
        String nacional=cursor.getString(4);
        String domicilio=cursor.getString(8);
        //tipo(9), user(10),passw(11)
        String ci_t=cursor.getString(12);
        String nom_ape_t=cursor.getString(13);
        String direc_t=cursor.getString(14);
        String tel_t=cursor.getString(15);

        grad=(TextView) view.findViewById(R.id.mo_curso_e);
        para=(TextView) view.findViewById(R.id.mo_paralelo_e);
        nam=(TextView) view.findViewById(R.id.mo_name_e);
        surnam=(TextView) view.findViewById(R.id.mo_surname_e);
        gener=(TextView) view.findViewById(R.id.mo_gender_e);
        fe_nac=(TextView) view.findViewById(R.id.mo_date_e);
        nacio=(TextView) view.findViewById(R.id.mo_nacionality_e);
        domi=(TextView) view.findViewById(R.id.mo_domicile_e);
        cit=(TextView) view.findViewById(R.id.mo_ci_t);
        nomt=(TextView) view.findViewById(R.id.mo_name_t);
        dirt=(TextView) view.findViewById(R.id.mo_direction_t);
        telt=(TextView) view.findViewById(R.id.mo_telephone_t);

        System.out.println("esto muestra datos del estudiante...."+cursor.getString(1));

        tv.setText(ci_est);
        para.setText(parallel);
        grad.setText(grade);
        nam.setText(name_);
        surnam.setText(surname);
        gener.setText(genero);
        fe_nac.setText(fec_nac);
        nacio.setText(nacional);
        domi.setText(domicilio);
        cit.setText(ci_t);
        nomt.setText(nom_ape_t);
        dirt.setText(direc_t);
        telt.setText(tel_t);

        dbManager.close();
        return view;
     }

}
