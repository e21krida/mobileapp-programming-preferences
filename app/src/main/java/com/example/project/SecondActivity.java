package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button goback;
    EditText username;
    TextView namepresent;
    SharedPreferences preferences;
    Button button;

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
        username = findViewById(R.id.edit_text);
        button = findViewById(R.id.save);
        namepresent = findViewById(R.id.namepresent);
        preferences = getSharedPreferences(("preferences"), MODE_PRIVATE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("name", username.getText().toString());
                editor.apply();
                namepresent.setText(username.getText().toString());
                String name = preferences.getString("name", "inget namn hittades");
            }
        });
    }
}