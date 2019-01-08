package cct.example.micolegio;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class Otros extends android.support.v4.app.Fragment {

    ListView lvAsistenciaDoc ;
    ListView lvPlanAnual;
    String[] ItemGeneral={"item 1","item 2","item 2","item 3","item 4"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_otros, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvAsistenciaDoc = (ListView) getView().findViewById(R.id.lvListarDocentes);
        lvPlanAnual = (ListView) getView().findViewById(R.id.lvPlanesAnuales);

        ArrayAdapter<String> adaptadorAsis = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_expandable_list_item_1, ItemGeneral);
        ArrayAdapter<String> adaptadorPlan = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_expandable_list_item_1, ItemGeneral);
        lvPlanAnual.setAdapter(adaptadorPlan);
        lvAsistenciaDoc.setAdapter(adaptadorAsis);

        lvAsistenciaDoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getActivity().getApplicationContext(),"Ver Asistencia de los Docentes",Toast.LENGTH_LONG).show();
            }
        });

        lvPlanAnual.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getActivity().getApplicationContext(),"Ver Plan Anual de los Docentes",Toast.LENGTH_LONG).show();
            }
        });

    }

}
