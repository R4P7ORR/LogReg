package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView loginName;
    private TextView loginPassword;
    private Button btnToLogin;
    private Button btnToRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
        btnToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toRegister = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(toRegister);
                finish();
            }
        });
    }

    public void attemptLogin(){
        if (loginName.getText().toString().isEmpty()){
            Toast.makeText(this, "A felhasználónév mezője nem lehet üres!", Toast.LENGTH_LONG).show();
        }else if (loginPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "A jelszó mezője nem lehet üres!", Toast.LENGTH_LONG).show();
        }else{
            Intent toLogin = new Intent(MainActivity.this, LoggedInActivity.class);
            startActivity(toLogin);
            finish();
        }
    }

    public void init(){
        loginName = findViewById(R.id.loginName);
        loginPassword = findViewById(R.id.loginPassword);
        btnToLogin = findViewById(R.id.btnToLogin);
        btnToRegister = findViewById(R.id.btnToRegister);
    }
}