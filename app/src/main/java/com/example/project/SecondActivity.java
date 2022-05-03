package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    Button goback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        goback = findViewById(R.id.back);
        goback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("==>", "Back button pressed");
                Intent intent = new Intent (SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }

        });
    }
}