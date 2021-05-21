package technomint.app.fancode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

   // private CircleImageView mDisplayImageView;
    private CircleImageView nav_image;
    private TextView number;
    private TextView name;
    FirebaseAuth mAuth;


    FrameLayout frameLayout;
    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

        Toolbar toolbar;
        DrawerLayout drawerLayout;
        NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout=(FrameLayout)findViewById(R.id.frameLayout);


        GoogleSignInAccount account= GoogleSignIn.getLastSignedInAccount(this);


        mAuth = FirebaseAuth.getInstance();



        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);
        toggle.syncState();

        navigationView = findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
        View navHeaderView = navigationView.getHeaderView(0);

        nav_image = (CircleImageView) navHeaderView.findViewById(R.id.nav_image);
        number = (TextView) navHeaderView.findViewById(R.id.number);
        name = (TextView) navHeaderView.findViewById(R.id.name);



        FirebaseUser user = mAuth.getCurrentUser();


        Glide.with(this)
                .load(user.getPhotoUrl())
                .into(nav_image);

        number.setText(user.getEmail());
        name.setText(user.getDisplayName());



        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        fragment = new CricketFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.miHome:
                        fragment = new CricketFragment();

                        break;

                    case R.id.minews:
                        fragment = new FootbalFragment();
                        break;

                    case R.id.mishedule:
                        fragment = new SheduleFragment();
                        break;

                    case R.id.misport:
                        fragment = new SportFragment();
                        break;


                }

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();


                return true;
            }
        });



























    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_home:
                Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_account:
                Intent intent = new Intent(MainActivity.this,ProfileScreen.class);
                startActivity(intent);
                break;


            case R.id.nav_suscripation:
                Intent i = new Intent(MainActivity.this,Subscripation.class);
                startActivity(i);
                break;

            case R.id.nav_invite:
                Intent i1 = new Intent(MainActivity.this,ScorCard.class);
                startActivity(i1);
                break;


            case R.id.nav_logout:
                FirebaseAuth.getInstance().signOut();
                LoginManager.getInstance().logOut();
                Intent i6 = new Intent(MainActivity.this,LoginScreen.class);
                startActivity(i6);
                finish();

                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}