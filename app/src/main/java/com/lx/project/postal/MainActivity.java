package com.lx.project.postal;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.lx.project.postal.fragment.ChatFragment;
import com.lx.project.postal.fragment.ProfileFragment;
import com.lx.project.postal.fragment.TablonFragment;

public class MainActivity extends AppCompatActivity {
    private ChatFragment chatFragment;
    private TablonFragment tablonFragment;
    private ProfileFragment profileFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.chatFragment = new ChatFragment();
        this.tablonFragment = new TablonFragment();
        this.profileFragment = new ProfileFragment();

        BottomNavigationView navigationView  = (BottomNavigationView) findViewById(R.id.navMenu);
        navigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.chatPostal:
                    getSupportFragmentManager().beginTransaction().replace(R.id.contentFrame, chatFragment).commit();
                    break;
                case R.id.mainPostal:
                    getSupportFragmentManager().beginTransaction().replace(R.id.contentFrame, tablonFragment).commit();
                    break;
                case R.id.profilePostal:
                    getSupportFragmentManager().beginTransaction().replace(R.id.contentFrame, profileFragment).commit();
                    break;
            }

            return false;
        });

        navigationView.setSelectedItemId(R.id.mainPostal);
    }
}