package com.recycler.agendacontactos.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.recycler.agendacontactos.views.ContactosFragment;
import com.recycler.agendacontactos.views.NotasFragment;

public class PagerAdapterTabsInicial extends FragmentPagerAdapter {

    public PagerAdapterTabsInicial(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ContactosFragment cf = new ContactosFragment();
                return cf;

            case 1:
                NotasFragment nf = new NotasFragment();
                return nf;

        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Contactos";

            case 1:
                return "Notas";
        }
        return null;
    }

}
