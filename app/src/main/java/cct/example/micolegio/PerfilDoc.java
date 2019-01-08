package cct.example.micolegio;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class PerfilDoc extends android.support.v4.app.Fragment {

    private DBManager dbManager;
    private SimpleCursorAdapter adapter;

    private Button addPlan;
    private TextView tv;
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

        View view = inflater.inflate(R.layout.fragment_perfil_doc, container, false);
        // Inflate the layout for this fragment
        Intent intent = getActivity().getIntent();
        tv=(TextView) view.findViewById(R.id.tex_ci_p);
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

        nam=(TextView) view.findViewById(R.id.tex_name_p);
        surnam=(TextView) view.findViewById(R.id.tex_surname_p);
        gener=(TextView) view.findViewById(R.id.tex_gener_p);
        fe_nac=(TextView) view.findViewById(R.id.tex_bir_p);
        mai=(TextView) view.findViewById(R.id.tex_mail_p);
        tele=(TextView) view.findViewById(R.id.tex_tele_p);
        spec=(TextView) view.findViewById(R.id.tex_spec_p);
        domi=(TextView) view.findViewById(R.id.tex_domil_p);

        System.out.println("esto muestra datos de la persona"+cursor.getString(1));

        tv.setText(ci_doc);
        nam.setText(name);
        surnam.setText(surname);
        gener.setText(genero);
        fe_nac.setText(fech_nac);
        mai.setText(mail);
        tele.setText(telephone);
        spec.setText(speciality);
        domi.setText(domicile);

        addPlan = (Button) view.findViewById(R.id.bttn_plan_anual);
        Toast.makeText(getActivity().getApplicationContext()," Se guarda el plan anual del docente",Toast.LENGTH_LONG).show();

        dbManager.close();
        return view;
    }
//    @Override
//    public void onClick(View arg0) {
//        switch (arg0.getId()) {
//            case R.id.bttn_plan_anual:
//                dbManager.open();
//                //dbManager.insertArchivo(nombreArchi,ci_doc);
//                dbManager.close();
//
//                //consulta
//
//
//                Toast.makeText(getActivity().getApplicationContext()," Se registro Archivo",Toast.LENGTH_LONG).show();
//                //CAMBIA DE TAB
//                ViewPager view_pager = (ViewPager) getActivity().findViewById(R.id.lvPlanesAnuales);
//                view_pager.setCurrentItem(1);
//
//                break;
//            //INSET CANCEL BUTTON HERE
//        }
//    }

}
