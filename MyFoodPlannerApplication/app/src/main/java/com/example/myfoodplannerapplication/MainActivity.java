package com.example.myfoodplannerapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myfoodplannerapplication.databinding.ActivityMainBinding;
import com.example.myfoodplannerapplication.favourites.view.FavouriteFragment;
import com.example.myfoodplannerapplication.home.view.HomeFragment;
import com.example.myfoodplannerapplication.plan.view.MyWeeklyPlanFragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    GoogleSignInOptions googlesignInOptions;
    GoogleSignInClient googlesignInClient;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HomeFragment _home = new HomeFragment();
        user = FirebaseAuth.getInstance().getCurrentUser();

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        googlesignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googlesignInClient = GoogleSignIn.getClient(this, googlesignInOptions);

        GoogleSignInAccount gAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (gAccount != null) {
            String gName = gAccount.getDisplayName();
            Toast.makeText(getApplicationContext(), "Welcome" + gName, Toast.LENGTH_SHORT).show();
        }

        mainBinding.navMenu.setOnItemSelectedListener(item -> {


            switch (item.getItemId()) {

                case R.id.nav_home:
                    replaceFragment(_home);
                    Toast.makeText(getApplicationContext(), "Home page", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.nav_favourites:
                    if (user.isAnonymous()) {
                        Toast.makeText(getApplicationContext(), "Register first to show", Toast.LENGTH_SHORT).show();
                    } else {
                        replaceFragment(new FavouriteFragment());
                        Toast.makeText(getApplicationContext(), "your favourites", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.nav_plan:
                    if (user.isAnonymous()) {
                        Toast.makeText(getApplicationContext(), "Register first to show", Toast.LENGTH_SHORT).show();
                    } else {
                        replaceFragment(new MyWeeklyPlanFragment());
                        Toast.makeText(getApplicationContext(), "Your Weekly Plan", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.nav_search:
                    replaceFragment(new SearchTypesFragment());
                    Toast.makeText(getApplicationContext(), "Search page", Toast.LENGTH_SHORT).show();
                    break;

            }

            return true;
        });
    }

    /*@Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }*/

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_logout:
                Toast.makeText(this, "Logging out", Toast.LENGTH_SHORT).show();
                //Facebook
                FirebaseAuth.getInstance().signOut();
                googlesignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        finish();
                        startActivity(new Intent(MainActivity.this, ResgistrationActivity.class));
                    }
                });
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }

    }
}