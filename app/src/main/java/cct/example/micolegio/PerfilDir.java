package cct.example.micolegio;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class PerfilDir extends android.support.v4.app.Fragment {

    private DBManager dbManager;
    private SimpleCursorAdapter adapter;


    private TextView tvc;
    private TextView nam;
    private TextView surnam;
    private TextView gener;
    private TextView fe_nac;
    private TextView mai;
    private TextView tele;
    private TextView spec;
    private TextView domi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_perfil_dir, container, false);
        // Inflate the layout for this fragment
        Intent intent = getActivity().getIntent();
        tvc=(TextView) view.findViewById(R.id.mo_ci_d);
        String ci_doc=intent.getStringExtra("ci");
        //consulta para obetener segun este ci
        dbManager=new DBManager(getActivity());
        dbManager.open();
        Cursor cursor = dbManager.fetchConsulDoc(ci_doc);

        String name=cursor.getString(1);
        String surname=cursor.getString(2);
        String genero=cursor.getString(3);
        String fech_nac=cursor.getString(4);
        String mail=cursor.getString(5);
        String telephone=cursor.getString(6);
        String speciality=cursor.getString(7);
        String domicile=cursor.getString(8);

        nam=(TextView) view.findViewById(R.id.mo_name_d);
        surnam=(TextView) view.findViewById(R.id.mo_ape_d);
        gener=(TextView) view.findViewById(R.id.mo_gen_d);
        fe_nac=(TextView) view.findViewById(R.id.mo_fe_na_d);
        mai=(TextView) view.findViewById(R.id.mo_mail_d);
        tele=(TextView) view.findViewById(R.id.mo_tele_d);
        spec=(TextView) view.findViewById(R.id.mo_spec_d);
        domi=(TextView) view.findViewById(R.id.mo_dom_d);

        System.out.println("esto muestra datos del director...."+cursor.getString(1));

        tvc.setText(ci_doc);
        nam.setText(name);
        surnam.setText(surname);
        gener.setText(genero);
        fe_nac.setText(fech_nac);
        mai.setText(mail);
        tele.setText(telephone);
        spec.setText(speciality);
        domi.setText(domicile);

        dbManager.close();
        return view;
    }
}
