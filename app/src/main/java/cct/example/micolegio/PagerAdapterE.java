package cct.example.micolegio;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class PagerAdapterE extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapterE(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
               PerfilE perfilE = new PerfilE();
                return perfilE;
            case 1:
               KardexE kardexE = new KardexE();
                return kardexE;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
