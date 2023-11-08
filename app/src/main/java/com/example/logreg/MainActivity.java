package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
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
    private Database userBase;
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
        //Cursor user = userBase.dataPull();
        if (loginName.getText().toString().isEmpty()){
            Toast.makeText(this, "A felhasználónév mezője nem lehet üres!", Toast.LENGTH_LONG).show();
        }else if (loginPassword.getText().toString().isEmpty()) {
            Toast.makeText(this, "A jelszó mezője nem lehet üres!", Toast.LENGTH_LONG).show();
        }/*else if ((user.getString(1).equals(loginName.getText()) || user.getString(2)
                .equals(loginName.getText())) && user.getString(3).equals(loginPassword.getText())){
            Intent toLogin = new Intent(MainActivity.this, LoggedInActivity.class);
            startActivity(toLogin);
            finish();
        }else{
            Toast.makeText(this, "Hibás felhasználónév vagy jelszó!", Toast.LENGTH_LONG).show();
        }*/
        else{
            tryUser();
        }
    }
    public void tryUser() {
        Cursor user = userBase.dataPull();
        int rows = user.getCount();
        boolean foundInDb = false;
        for (int i = 0; i < rows; i++) {
            user.moveToPosition(i);
            if ((user.getString(1).equals(loginName.getText().toString()) || user.getString(2)
                    .equals(loginName.getText().toString())) && user.getString(3).equals(loginPassword.getText().toString())) {
                foundInDb = true;
                Intent toLogin = new Intent(MainActivity.this, LoggedInActivity.class);
                toLogin.putExtra("userL", user.getString(4));
                startActivity(toLogin);
                finish();
                break;
            }
        }
        if (!foundInDb) {
            Toast.makeText(this, "No user found in database!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "User found!", Toast.LENGTH_LONG).show();
        }

    }

    public void init(){
        loginName = findViewById(R.id.loginName);
        loginPassword = findViewById(R.id.loginPassword);
        btnToLogin = findViewById(R.id.btnToLogin);
        btnToRegister = findViewById(R.id.btnToRegister);

        userBase = new Database(MainActivity.this);
    }
}