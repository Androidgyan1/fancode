package technomint.app.fancode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Subscripation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscripation);
    }

    public void subback(View view) {
        Intent intent = new Intent(Subscripation.this,MainActivity.class);
        startActivity(intent);
        finish();

    }
}