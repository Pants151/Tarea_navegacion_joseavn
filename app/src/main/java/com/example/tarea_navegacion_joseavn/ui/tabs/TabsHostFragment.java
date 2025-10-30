package com.example.tarea_navegacion_joseavn.ui.tabs;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.tarea_navegacion_joseavn.R;
import com.example.tarea_navegacion_joseavn.databinding.FragmentTabsHostBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class TabsHostFragment extends Fragment {

    private FragmentTabsHostBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTabsHostBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Configurar el ViewPager2 con el adaptador
        TabsViewPagerAdapter adapter = new TabsViewPagerAdapter(this);
        binding.viewPager.setAdapter(adapter);

        // Conectar el TabLayout con el ViewPager2
        new TabLayoutMediator(binding.tabLayout, binding.viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText(getString(R.string.tab_a));
                            break;
                        case 1:
                            tab.setText(getString(R.string.tab_b));
                            break;
                        case 2:
                            tab.setText(getString(R.string.tab_c));
                            break;
                    }
                }
        ).attach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Evitar memory leaks
    }
}
