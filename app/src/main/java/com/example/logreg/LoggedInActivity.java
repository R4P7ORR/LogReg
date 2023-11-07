package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class LoggedInActivity extends AppCompatActivity {

    private TextView loggedUser;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        init();
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMain = new Intent(LoggedInActivity.this, MainActivity.class);
                startActivity(toMain);
                finish();
            }
        });
    }

    public void init(){
        loggedUser = findViewById(R.id.loggedUser);
        btnLogout = findViewById(R.id.btnLogout);
    }
}