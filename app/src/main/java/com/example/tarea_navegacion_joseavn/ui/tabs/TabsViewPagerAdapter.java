package com.example.tarea_navegacion_joseavn.ui.tabs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabsViewPagerAdapter extends FragmentStateAdapter {

    // Hay 3 pestañas
    private static final int NUM_TABS = 3;

    public TabsViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Retorna el fragment correspondiente a la posición
        switch (position) {
            case 0:
                return new TabAFragment();
            case 1:
                return new TabBFragment();
            case 2:
                return new TabCFragment();
            default:
                return new TabAFragment(); // Fallback
        }
    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }
}
