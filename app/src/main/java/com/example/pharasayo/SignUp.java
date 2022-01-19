package com.example.pharasayo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {

    private TextInputEditText username
            ,fullname
            ,email
            ,phone
            ,password
            ,address
            ,unit
            ,location;

    private Button createAcc
            ,back;

    private Acc_DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.username);
        fullname = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.pass);
        address = findViewById(R.id.address);
        unit = findViewById(R.id.unit);
        location = findViewById(R.id.location);

        createAcc = findViewById(R.id.signup);
        back = findViewById(R.id.back);

        createAcc.setOnClickListener(v -> {
            if(fullname.getText().toString().length() == 0 ||
                    username.getText().toString().length() == 0 ||
                    email.getText().toString().length() == 0 ||
                    phone.getText().toString().length() == 0 ||
                    password.getText().toString().length() == 0 ||
                    address.getText().toString().length() == 0 ||
                    unit.getText().toString().length() == 0 ||
                    location.getText().toString().length() == 0
            ){
                if(fullname.getText().toString().length() == 0){
                    fullname.setError("Enter your full name");
                }
                if(username.getText().toString().length() == 0){
                    username.setError("Enter your username");
                }
                if(email.getText().toString().length() == 0){
                    email.setError("Enter your email");
                }
                if(phone.getText().toString().length() == 0){
                    phone.setError("Enter your phone");
                }
                if(password.getText().toString().length() == 0){
                    password.setError("Enter your password");
                }
                if(address.getText().toString().length() == 0){
                    address.setError("Enter your address");
                }
                if(unit.getText().toString().length() == 0){
                    unit.setError("Enter your unit");
                }
                if(location.getText().toString().length() == 0){
                    location.setError("Enter your location");
                }
            }else{
                dbManager = new Acc_DBManager(this);
                dbManager.open();

                dbManager.insert(
                        username.getText().toString(),
                        password.getText().toString(),
                        fullname.getText().toString(),
                        email.getText().toString(),
                        phone.getText().toString(),
                        address.getText().toString(),
                        unit.getText().toString(),
                        location.getText().toString()
                );
                Toast.makeText(getApplicationContext(), "Account Created", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(getIntent());
            }
        });

        back.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}