package cct.example.micolegio;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class PageAdapterP extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PageAdapterP (FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                PerfilDoc perfilDoc = new PerfilDoc();
                return  perfilDoc;
            case 1:

              AsistenciaEstu asistenciaEstu = new AsistenciaEstu();
                return  asistenciaEstu;
            case 2:
               RegistroAlumnoFragment registroAlumnoFragment = new RegistroAlumnoFragment();
                return   registroAlumnoFragment;


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
