package com.nilsrindlisbacher.trick_manager;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.nilsrindlisbacher.trick_manager.databinding.ActivityMainBinding;

import org.json.JSONException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_overview, R.id.navigation_generator)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    public void getRandomTrick(View view) throws IOException, JSONException {
        Connection connection = new Connection();

        Spinner spinner = (Spinner)findViewById(R.id.type_spinner);
        String type = spinner.getSelectedItem().toString();

        String randomTrick = connection.getRandomTrick(type);

        TextView trickDisplay=findViewById(R.id.trick_display);
        trickDisplay.setText(randomTrick);
    }

}