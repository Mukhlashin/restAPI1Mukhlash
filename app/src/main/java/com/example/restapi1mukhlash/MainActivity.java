package com.example.restapi1mukhlash;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.restapi1mukhlash.fragment.MatchFragment;
import com.example.restapi1mukhlash.fragment.TeamFragment;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            fm = getSupportFragmentManager();
            switch (menuItem.getItemId()) {
                case R.id.rv1:
                    fm.beginTransaction().replace(R.id.main_container, new TeamFragment()).addToBackStack("").commit();
                    return true;
                case R.id.rv2:
                    fm.beginTransaction().replace(R.id.main_container, new MatchFragment()).addToBackStack("").commit();
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.main_container, new TeamFragment()).addToBackStack("").commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

    }
}
