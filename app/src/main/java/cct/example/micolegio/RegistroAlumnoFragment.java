package cct.example.micolegio;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;


public class RegistroAlumnoFragment extends android.support.v4.app.Fragment implements View.OnClickListener{

    private EditText eT_CI ;
    private EditText eT_LAST_NAME;
    private EditText eT_GENDER ;
    private EditText eT_NAMES;
    private EditText eT_NATIONALITY;
    private EditText eT_BIRTHDATE;
    private EditText eT_GRADE;
    private EditText eT_PARALLEL;
    private EditText eT_DOMICILE;
    private EditText eT_CI_T ;
    private EditText eT_NAME_T;
    private EditText eT_DIRECTION_T ;
    private EditText eT_TELEPHONE_T;

    private Button btn_SaveAlumno;
    private DBManager dbManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registro_alumno, container, false);
            eT_CI = (EditText)view.findViewById(R.id.et_ci);
            eT_LAST_NAME = (EditText)view.findViewById(R.id.et_lastname);
            eT_GENDER = (EditText)view.findViewById(R.id.et_gender);
            eT_NAMES = (EditText)view.findViewById(R.id.et_names);
            eT_NATIONALITY = (EditText)view.findViewById(R.id.et_nationality);
            eT_BIRTHDATE = (EditText)view.findViewById(R.id.et_birthday);
            eT_GRADE = (EditText)view.findViewById(R.id.et_grade);
            eT_PARALLEL = (EditText)view.findViewById(R.id.et_parallel);
            eT_DOMICILE = (EditText)view.findViewById(R.id.et_domicile);
            eT_CI_T = (EditText)view.findViewById(R.id.et_ci_tutor);
            eT_NAME_T = (EditText)view.findViewById(R.id.et_name_tutor);
            eT_DIRECTION_T = (EditText)view.findViewById(R.id.et_domicilie_work_tutor);
            eT_TELEPHONE_T = (EditText)view.findViewById(R.id.et_telephone_tutor);

        btn_SaveAlumno = (Button) view.findViewById(R.id.btn_addAlumno);
            dbManager = new DBManager(getActivity());

            btn_SaveAlumno.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.btn_addAlumno:

                    //Convert our edit texts to strings
                    String ci = eT_CI.getText().toString();
                    String last_name = eT_LAST_NAME.getText().toString();
                    String gender = eT_GENDER.getText().toString();
                    String names = eT_NAMES.getText().toString();
                    String nationality = eT_NATIONALITY.getText().toString();
                    String birthdate = eT_BIRTHDATE.getText().toString();
                    String grade = eT_GRADE.getText().toString();
                    String parallel = eT_PARALLEL.getText().toString();
                    String domicile = eT_DOMICILE.getText().toString();
                    String ci_t = eT_CI_T.getText().toString();
                    String name_t = eT_NAME_T.getText().toString();
                    String domicile_t = eT_DIRECTION_T.getText().toString();
                    String telephone_t = eT_TELEPHONE_T.getText().toString();

                //Write all of this to the database
                    dbManager.open();
                    dbManager.insert(ci,names, last_name,gender,nationality,birthdate,grade,parallel,domicile,"estudiante",ci_t,name_t,domicile_t,telephone_t);
                    //dbManager.insert(ci,names, last_name,gender,nationality,birthdate);
                    dbManager.close();

                //consulta


                    Toast.makeText(getActivity().getApplicationContext()," Se registro el Alumno",Toast.LENGTH_LONG).show();
                //CAMBIA DE TAB
                    ViewPager view_pager = (ViewPager) getActivity().findViewById(R.id.pagerPro);
                    view_pager.setCurrentItem(1);

                break;
            //INSET CANCEL BUTTON HERE
        }
    }

}

