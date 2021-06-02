package technomint.app.fancode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.hbb20.CountryCodePicker;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class LoginScreen extends AppCompatActivity {


    private static final int RC_SIGN_IN = 123;
    FirebaseAuth phoneAuth;
    private Button facebook;
    private CallbackManager mCallbackManager;
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth1;

    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        ///////dynamic link


        FirebaseDynamicLinks.getInstance()
                .getDynamicLink(getIntent())
                .addOnSuccessListener(this, new OnSuccessListener<PendingDynamicLinkData>() {
                    @Override
                    public void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
                        // Get deep link from result (may be null if no link is found)
                        Uri deepLink = null;
                        if (pendingDynamicLinkData != null) {
                            deepLink = pendingDynamicLinkData.getLink();

                            Log.e("TAG","my link "+deepLink.toString());
                        }


                        // Handle the deep link. For example, open the linked
                        // content, or apply promotional credit to the user's
                        // account.
                        // ...

                        // ...
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG", "getDynamicLink:onFailure", e);
                    }
                });








        phoneAuth = FirebaseAuth.getInstance();

        progressBar = findViewById(R.id.progress_sgin);

        ////edittext
        final EditText inputMobile = findViewById(R.id.input_mobile);
        Button buttonGetOtp = findViewById(R.id.getOtp);

        mAuth1 = FirebaseAuth.getInstance();
        mCallbackManager = CallbackManager.Factory.create();
        facebook=findViewById(R.id.facebook);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                LoginManager.getInstance().logInWithReadPermissions(LoginScreen.this, Arrays.asList("email","public_profile"));
                LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.d("msg", "facebook:onSuccess:" + loginResult);
                        handleFacebookAccessToken(loginResult.getAccessToken());

                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onCancel() {
                        Log.d("mg", "facebook:onCancel");
                        progressBar.setVisibility(View.GONE);
                        // ...
                    }

                    @Override
                    public void onError(FacebookException error) {
                        Log.d("error", "facebook:onError", error);
                        progressBar.setVisibility(View.GONE);
                        // ...
                    }
                });

            }
        });






































        buttonGetOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputMobile.getText().toString().trim().isEmpty()){
                    Toast.makeText(LoginScreen.this,"Enter Mobile",Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91" + inputMobile.getText().toString(),
                        60,
                        TimeUnit.SECONDS,
                        LoginScreen.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                               // signInWithPhoneAuthCredential(phoneAuthCredential);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(LoginScreen.this,e.getMessage(),Toast.LENGTH_SHORT).show();

                                progressBar.setVisibility(View.GONE);
                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                Intent intent = new Intent(getApplicationContext(),OtpScreen.class);
                                intent.putExtra("mobile",inputMobile.getText().toString());
                                intent.putExtra("verificationId",verificationId);
                                startActivity(intent);

                                progressBar.setVisibility(View.GONE);
                            }


                        }
                );


            }
        });



        mAuth = FirebaseAuth.getInstance();
      //  mCallbackManager = CallbackManager.Factory.create();

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);



    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential phoneAuthCredential) {
        phoneAuth.signInWithCredential(phoneAuthCredential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(LoginScreen.this,OtpScreen.class));
                            finish();
                            FirebaseUser user = task.getResult().getUser();
                            // ...
                        } else {
                            Toast.makeText(LoginScreen.this, "Verification Filed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }

    private void handleFacebookAccessToken(AccessToken token) {

        Log.d("snd", "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth1.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressBar.setVisibility(View.VISIBLE);
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("send", "signInWithCredential:success");
                            FirebaseUser user = mAuth1.getCurrentUser();
                            Intent i8 = new Intent(LoginScreen.this,MainActivity.class);
                            startActivity(i8);
                            finish();

                            progressBar.setVisibility(View.GONE);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("sed", "signInWithCredential:failure", task.getException());
                            Toast.makeText(LoginScreen.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                            progressBar.setVisibility(View.GONE);
                        }

                        // ...
                    }
                });


    }

    public void next(View view) {

        }

    public void google(View view) {
        progressBar.setVisibility(View.VISIBLE);
        sign();

    }

    private void sign() {

        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result back to the Facebook SDK
        mCallbackManager.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d("q", "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w("as", "Google sign in failed", e);
                // ...
            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressBar.setVisibility(View.VISIBLE);
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("de", "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i5 = new Intent(LoginScreen.this,MainActivity.class);
                            startActivity(i5);
                            finish();
                            progressBar.setVisibility(View.GONE);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("se", "signInWithCredential:failure", task.getException());
                            progressBar.setVisibility(View.GONE);
                        }

                        // ...
                    }
                });

    }

}