package com.example.smartglasses;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

    }

    private  BottomNavigationView.OnNavigationItemSelectedListener navListener =
         new BottomNavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                 Fragment selectedFracgement = null;

                 switch (item.getItemId())
                 {
                     case R.id.nav_home:
                         selectedFracgement = new HomeFragment();
                     break;
                     case R.id.nav_account:
                         selectedFracgement = new AccountFragment();
                         break;
                     case R.id.nav_group:
                         selectedFracgement = new GroupFragment();
                         break;
                     case R.id.nav_glasses:
                         selectedFracgement = new GlassesFragment();
                         break;
                 }

                 getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                         selectedFracgement).commit();
                 return true;
             }
         };
}
