package com.dawnsoft.dawn.nepalyoga;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.dawnsoft.dawn.nepalyoga.helper.BottomNavigationViewHelper;
import com.dawnsoft.dawn.nepalyoga.dashboardfrags.CommunityFragment;
import com.dawnsoft.dawn.nepalyoga.dashboardfrags.ExerciseFragment;
import com.dawnsoft.dawn.nepalyoga.dashboardfrags.HomeFragment;
import com.dawnsoft.dawn.nepalyoga.dashboardfrags.ProfileFragment;

public class DashboardActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Fragment fragment;
    private DrawerLayout drawerLayout;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//        getWindow().setStatusBarColor(Color.TRANSPARENT);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        //initializing navigation drawer
        initNavigationDrawer();

        //starting the fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.containerDashboard, new HomeFragment()).commit();

        //bottom navigation
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav_view);
        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }
        });
    }

    //loading fragment from bottom navigation using selectFragment method
    private void selectFragment(MenuItem item) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (item.getItemId()) {
            case R.id.menu_home:
                fragment = new HomeFragment();
                toolbar.setTitle("Home");
                break;
            case R.id.menu_exercise:
                fragment = new ExerciseFragment();
                toolbar.setTitle("Exercise");
                break;
            case R.id.menu_community:
                fragment = new CommunityFragment();
                toolbar.setTitle("Community");
                break;
            case R.id.menu_profile:
                fragment = new ProfileFragment();
                toolbar.setTitle("Profile");
                break;
        }

        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerDashboard, fragment).commit();

    }

    //loading navigation drawer
    public void initNavigationDrawer(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_ytt_courses:
                    case R.id.menu_poses:
                    case R.id.menu_satkarma:
                    case R.id.menu_asan:
                    case R.id.menu_pranayam:
                    case R.id.menu_meditation:
                    case R.id.menu_darshan:
                }
                return true;
            }
        });

        View header = navigationView.getHeaderView(0);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
