package com.example.project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    EditText username;
    TextView namepresent;
    SharedPreferences preferences;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        String name = preferences.getString("name", "inget namn hittades");
        namepresent.setText(name);
    }
}
