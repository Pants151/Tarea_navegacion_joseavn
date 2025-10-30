package com.example.tarea_navegacion_joseavn;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.tarea_navegacion_joseavn.databinding.ActivityMainBinding;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AppBarConfiguration appBarConfiguration;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflar el layout usando ViewBinding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configurar la Toolbar como la ActionBar
        setSupportActionBar(binding.toolbar);

        // Obtener el NavController desde el NavHostFragment
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();

        // Incluimos TODOS los destinos principales de TODOS los menús.
        Set<Integer> topLevelDestinations = new HashSet<>();

        // Destinos del Drawer
        topLevelDestinations.add(R.id.drawer1Fragment);
        topLevelDestinations.add(R.id.drawer2Fragment);
        topLevelDestinations.add(R.id.drawer3Fragment);
        topLevelDestinations.add(R.id.tabsHostFragment);

        // Destinos del BottomNav
        topLevelDestinations.add(R.id.bottom1Fragment);
        topLevelDestinations.add(R.id.bottom2Fragment);
        topLevelDestinations.add(R.id.bottom3Fragment);

        // Destinos del OptionsMenu
        topLevelDestinations.add(R.id.options1Fragment);
        topLevelDestinations.add(R.id.options2Fragment);
        topLevelDestinations.add(R.id.options3Fragment);


        // Construir la configuración, conectándola con el DrawerLayout
        appBarConfiguration = new AppBarConfiguration.Builder(topLevelDestinations)
                .setOpenableLayout(binding.drawerLayout)
                .build();


        // Esto gestiona el título de la barra y el icono de hamburguesa/atrás.
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration);

        // Esto gestiona los clics en los ítems del menú lateral.
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Esto gestiona los clics en los ítems del menú inferior.
        NavigationUI.setupWithNavController(binding.bottomNavView, navController);

        // Manejar el botón "Atrás" del sistema para cerrar el drawer si está abierto
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    binding.drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    // Si el callback está habilitado, pero no queremos sobreescribir el comportamiento,
                    setEnabled(false);
                    getOnBackPressedDispatcher().onBackPressed();
                }
            }
        });
    }

    // --- Gestión del OptionsMenu (Menú de 3 puntos) ---
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflar el menú de opciones
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item);
    }

    // --- Gestión del Botón Arriba/Hamburguesa ---
    @Override
    public boolean onSupportNavigateUp() {

        // Dejar que NavigationUI maneje el clic en el botón "Atrás" o "Hamburguesa"
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
