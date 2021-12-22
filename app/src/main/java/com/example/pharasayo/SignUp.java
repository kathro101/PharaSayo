package com.example.pharasayo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

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
    }
}