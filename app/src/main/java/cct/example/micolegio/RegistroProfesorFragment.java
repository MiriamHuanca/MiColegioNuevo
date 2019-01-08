package cct.example.micolegio;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroProfesorFragment extends android.support.v4.app.Fragment implements View.OnClickListener{

    private EditText eT_CI_P ;
    private EditText eT_NAME_P;
    private EditText eT_SURNAME_P;
    private EditText eT_GENDER_P ;
    private EditText eT_BIRTHDATE;
    private EditText eT_MAIL_P;
    private EditText eT_TELEPHONE_P;
    private EditText eT_SPECIALTY;
    private EditText eT_DOMICILE_P;

    private Button btn_SaveProfesor;
    private DBManager dbManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registro_profesor, container, false);
        eT_CI_P = (EditText)view.findViewById(R.id.et_ci_p);
        eT_NAME_P = (EditText)view.findViewById(R.id.et_name_p);
        eT_SURNAME_P = (EditText)view.findViewById(R.id.et_surname_p);
        eT_GENDER_P = (EditText)view.findViewById(R.id.et_gender_p);
        eT_BIRTHDATE = (EditText)view.findViewById(R.id.et_birthday_p);
        eT_MAIL_P = (EditText)view.findViewById(R.id.et_mail_p);
        eT_TELEPHONE_P = (EditText)view.findViewById(R.id.et_telephone_p);
        eT_SPECIALTY = (EditText)view.findViewById(R.id.et_specialty);
        eT_DOMICILE_P = (EditText)view.findViewById(R.id.et_domicile_p);

        btn_SaveProfesor = (Button) view.findViewById(R.id.btn_addProfesor);
        dbManager = new DBManager(getActivity());

        btn_SaveProfesor.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.btn_addProfesor:

                //Convert our edit texts to strings
                String ci = eT_CI_P.getText().toString();
                String names = eT_NAME_P.getText().toString();
                String surname = eT_SURNAME_P.getText().toString();
                String gender = eT_GENDER_P.getText().toString();
                String birthdate = eT_BIRTHDATE.getText().toString();
                String mail = eT_MAIL_P.getText().toString();
                String telephone = eT_TELEPHONE_P.getText().toString();
                String specialty = eT_SPECIALTY.getText().toString();
                String domicile = eT_DOMICILE_P.getText().toString();

                //Write all of this to the database
                dbManager.open();
                dbManager.insertPro(ci,names,surname,gender,birthdate,mail,telephone,specialty,domicile,"profesor");
                //dbManager.insertPro(ci,names, last_name,gender,nationality,birthdate);
                dbManager.close();

                //consulta


                Toast.makeText(getActivity().getApplicationContext()," 2Se registro al Profesor",Toast.LENGTH_LONG).show();
                //CAMBIA DE TAB
                ViewPager view_pager_p = (ViewPager) getActivity().findViewById(R.id.pagerDir);
                view_pager_p.setCurrentItem(1);

                break;
            //INSET CANCEL BUTTON HERE
        }
    }
}
