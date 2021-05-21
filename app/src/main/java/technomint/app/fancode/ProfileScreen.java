package technomint.app.fancode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileScreen extends AppCompatActivity {

    // private CircleImageView mDisplayImageView;
    private CircleImageView profile_image;
    private TextView profile_name;
    private TextView profile_gmail;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);

        GoogleSignInAccount account= GoogleSignIn.getLastSignedInAccount(this);


        mAuth = FirebaseAuth.getInstance();


        profile_image = (CircleImageView)findViewById(R.id.profile_image);
        profile_name = (TextView)findViewById(R.id.profile_name);
        profile_gmail = (TextView)findViewById(R.id.profile_gmail);
        FirebaseUser user = mAuth.getCurrentUser();

        Glide.with(this)
                .load(user.getPhotoUrl())
                .into(profile_image);

        profile_gmail.setText(user.getEmail());
        profile_name.setText(user.getDisplayName());


    }

    public void profile_logout(View view) {

        FirebaseAuth.getInstance().signOut();
        LoginManager.getInstance().logOut();
        Intent i6 = new Intent(ProfileScreen.this,LoginScreen.class);
        startActivity(i6);
        finish();


    }

    public void profile(View view) {

        Intent intent = new Intent(ProfileScreen.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}