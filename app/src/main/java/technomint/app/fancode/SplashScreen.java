package technomint.app.fancode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (FirebaseAuth.getInstance().getCurrentUser()==null){
                    Intent i9 = new Intent(SplashScreen.this,LoginScreen.class);
                    startActivity(i9);
                    finish();
                }
                else{
                    Intent i5 = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(i5);
                    finish();

                }
            }
        },3000);

    }
}