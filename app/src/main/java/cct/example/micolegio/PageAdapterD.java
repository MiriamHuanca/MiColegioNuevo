package cct.example.micolegio;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class PageAdapterD extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PageAdapterD (FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                PerfilDir perfilDir = new PerfilDir();
                return perfilDir;

            case 1:
                VerDocentes verDocentes = new VerDocentes();
                return  verDocentes;
            case 2:
                AsistenciaEstu asistenciaEstu = new AsistenciaEstu();
                return  asistenciaEstu;

            case 3:
                RegistroProfesorFragment registroProfesorFragment = new RegistroProfesorFragment();
                return  registroProfesorFragment;
            case 4:
                Otros otros = new Otros();
                return otros;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}
