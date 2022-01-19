package com.example.pharasayo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {

    private Button signup, mLogin;
    private Acc_DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbManager = new Acc_DBManager(this);
        dbManager.open();

        signup = findViewById(R.id.signup_screen);
        mLogin = findViewById(R.id.mainLogin);
        mLogin.setOnClickListener(v -> {

        });

        final ImageView g_signin = findViewById(R.id.g_signin);

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(this,googleSignInOptions);

        GoogleSignInAccount googleSignInAccount = GoogleSignIn.getLastSignedInAccount(this);

        //checking if user already signed in
        if(googleSignInAccount != null){
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
            finish();
        }

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

                //getting signed in account after user selected an account from google accounts dialog
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(result.getData());
                handleSignInTask(task);
            }
        });

        g_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = googleSignInClient.getSignInIntent();
                activityResultLauncher.launch(signInIntent);
            }
        });

        signup.setOnClickListener(v -> {
            startActivity(new Intent(this, SignUp.class));
        });
    }

    private void handleSignInTask(Task<GoogleSignInAccount> task){
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);

            //account data
            final String getFullname= account.getDisplayName();
            final String getEmail = account.getEmail();
            final Uri getPhotoUrl = account.getPhotoUrl();

            //Opening HomeActivity
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
            finish();
        } catch (ApiException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed or Cancelled", Toast.LENGTH_SHORT).show();
        }

    }
}