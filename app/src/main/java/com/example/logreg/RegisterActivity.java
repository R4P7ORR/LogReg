package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private TextView registerEmail;
    private TextView registerUsername;
    private TextView registerPassword;
    private TextView registerFullName;
    private Button btnRegister;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tryRegister();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMain = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(toMain);
                finish();
            }
        });
    }

    public void tryRegister(){
        if (registerEmail.getText().toString().isEmpty()){
            Toast.makeText(this,"Az email cím mezője nem lehet üres!", Toast.LENGTH_LONG).show();
        } else if (registerUsername.getText().toString().isEmpty()) {
            Toast.makeText(this,"A felhasználónév mezője nem lehet üres!", Toast.LENGTH_LONG).show();
        } else if (registerPassword.getText().toString().isEmpty()) {
            Toast.makeText(this,"A jelszó mezője nem lehet üres!", Toast.LENGTH_LONG).show();
        } else if (registerFullName.getText().toString().isEmpty()) {
            Toast.makeText(this,"A teljes név mezője nem lehet üres!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"Sikeres regisztráció!", Toast.LENGTH_LONG).show();
            Intent toMain = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(toMain);
            finish();
        }
    }

    public void init(){
        registerEmail = findViewById(R.id.registerEmail);
        registerUsername = findViewById(R.id.registerUsername);
        registerPassword = findViewById(R.id.registerPassword);
        registerFullName = findViewById(R.id.registerFullName);
        btnRegister = findViewById(R.id.btnRegister);
        btnCancel = findViewById(R.id.btnCancel);
    }
}