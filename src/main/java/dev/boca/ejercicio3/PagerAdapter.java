package dev.boca.ejercicio3;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int nNumOfTabs;
    public PagerAdapter(@NonNull FragmentManager fm, int nNumOfTabs) {
        super(fm);
        this.nNumOfTabs = nNumOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new BurgerFragment();
            case 1: return new ComplementsFragment();
            case 2: return new DessertsFragment();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return nNumOfTabs;
    }
}
