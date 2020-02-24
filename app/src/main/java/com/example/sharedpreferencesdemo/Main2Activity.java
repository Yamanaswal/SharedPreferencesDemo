package com.example.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    Preferences preferences;
    Button id_log_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("Second Activty");

        id_log_out = findViewById(R.id.id_log_out);
        id_log_out.setOnClickListener(this);

        preferences = new Preferences(Main2Activity.this);
        String name = preferences.getname();
        String password = preferences.getPassword();
        Toast.makeText(this, name + "  " + password, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.id_log_out){
            preferences.clearSp();
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
            finish();
        }
    }
}
