package com.example.pregamate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.pregamate.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActionBarDrawerToggle toggle;
    private FirebaseAuth auth;


    private int trimsPregnant;

    @SuppressLint("NonConstantResourceId")
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.bottom_home:
                        fragment = new HomeFragment();
                    case R.id.bottom_community:
                        return true;
                    case R.id.bottom_emergency:
                        return true;
                    case R.id.bottom_user:
                        return true;
                    case R.id.navigationMenu:
                        DrawerLayout drawer = findViewById(R.id.drawer_layout);
                        drawer.openDrawer(GravityCompat.START);
                        return true;
                }
                return false;
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_user, R.id.nav_signout)
                .setOpenableLayout(drawer)
                .build();
//        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        navigationView.setNavigationItemSelectedListener(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
//
//        MenuItem signoutMenu = findViewById(R.id.action_signout);
//        signoutMenu.setOnMenuItemClickListener(item -> {
//            auth.signOut();
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//            startActivity(intent);
//            return false;
//        });


        cardClickListener();
    }

    private void cardClickListener() {

        CardView diets = findViewById(R.id.diets);
        CardView exercises = findViewById(R.id.exercises);
        CardView tests = findViewById(R.id.tests);
        CardView changesMum = findViewById(R.id.changesMum);
        CardView babyGrowth = findViewById(R.id.babyGrowth);
        CardView doDont = findViewById(R.id.doDont);

        TextView dietsTv = findViewById(R.id.dietsText);
        TextView exercisesTv = findViewById(R.id.exercisesText);
        TextView testsTv = findViewById(R.id.testsText);
        TextView changesMumTv = findViewById(R.id.changesMumText);
        TextView babyGrowthTv = findViewById(R.id.babyGrowthText);
        TextView doDontTv = findViewById(R.id.doDontText);

        Intent intent = getIntent();
        int trimsPregnant = intent.getIntExtra("trimsPregnant", 1);

        TextView trimesterTitle = findViewById(R.id.trimesterTitle);
        TextView trimesterDesc = findViewById(R.id.trimesterDesc);

//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//        DocumentReference docRef = db.collection("Trimesters").document("First");
//
//        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()) {
//                    DocumentSnapshot document = task.getResult();
//                    if (document.exists()) {
//                        dietsTv.setText(document.getString("Diets"));
//                    }
//                    else {
//                        Toast.makeText(getApplicationContext(), "No such field", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                else {
//                    Toast.makeText(getApplicationContext(), "No such document", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        if (trimsPregnant==1){
           trimesterTitle.setText(R.string.trim1);
           trimesterDesc.setText(R.string.trim1Desc);
        }
        else if (trimsPregnant==2){
            trimesterTitle.setText(R.string.trim2);
            trimesterDesc.setText(R.string.trim2Desc);
        }
        else if (trimsPregnant==3){
            trimesterTitle.setText(R.string.trim3);
            trimesterDesc.setText(R.string.trim3Desc);
        }

        diets.setOnClickListener(v -> {
            if (dietsTv.getVisibility()== View.GONE){
                dietsTv.setVisibility(View.VISIBLE);
            }
            else {
                dietsTv.setVisibility(View.GONE);
            }
        });
        exercises.setOnClickListener(v -> {
            if (exercisesTv.getVisibility()== View.GONE){
                exercisesTv.setVisibility(View.VISIBLE);
            }
            else {
                exercisesTv.setVisibility(View.GONE);
            }
        });
        tests.setOnClickListener(v -> {
            if (testsTv.getVisibility()== View.GONE){
                testsTv.setVisibility(View.VISIBLE);
            }
            else {
                testsTv.setVisibility(View.GONE);
            }
        });
        changesMum.setOnClickListener(v -> {
            if (changesMumTv.getVisibility()== View.GONE){
                changesMumTv.setVisibility(View.VISIBLE);
            }
            else {
                changesMumTv.setVisibility(View.GONE);
            }
        });
        babyGrowth.setOnClickListener(v -> {
            if (babyGrowthTv.getVisibility()== View.GONE){
                babyGrowthTv.setVisibility(View.VISIBLE);
            }
            else {
                babyGrowthTv.setVisibility(View.GONE);
            }
        });
        doDont.setOnClickListener(v -> {
            if (doDontTv.getVisibility()== View.GONE){
                doDontTv.setVisibility(View.VISIBLE);
            }
            else {
                doDontTv.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            return true;
        } else if (id == R.id.nav_user) {
            
        }
        else if (id == R.id.nav_signout) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}