package cct.example.micolegio;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                RegistroAlumnoFragment registroAlumnoFragment = new RegistroAlumnoFragment();
                return registroAlumnoFragment;
            case 1:
              RegistroProfesorFragment registroProfesorFragment = new RegistroProfesorFragment();
                return registroProfesorFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
