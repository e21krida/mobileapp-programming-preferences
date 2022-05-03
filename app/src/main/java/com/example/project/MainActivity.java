package com.example.project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    TextView TextViewName;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextViewName = findViewById(R.id.name);

        preferences = getSharedPreferences(("preferences"), MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name", "Krille");
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();

        preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        String name = preferences.getString("name", "inget namn hittades");
        TextViewName.setText(name);
    }
}
