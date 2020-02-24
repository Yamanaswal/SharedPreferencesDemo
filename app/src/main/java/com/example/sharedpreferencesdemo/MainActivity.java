package com.example.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Preferences preferences;
    EditText id_user_name,id_password;
    Button id_send;

    public void setIds(){
        id_user_name = findViewById(R.id.id_user_name);
        id_password = findViewById(R.id.id_password);
        id_send = findViewById(R.id.id_send);
    }

    public void setListeners(){
        id_send.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set ids and listeners
        setIds();
        setListeners();

        preferences = new Preferences(MainActivity.this);
        boolean b = preferences.isLogin();
        if(b == true){
            Intent i = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(i);
            finish();
        }
        else{
            Toast.makeText(this, "Please Log in", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.id_send){
            String username = id_user_name.getText().toString();
            String password = id_password.getText().toString();
            if(!username.isEmpty() && !password.isEmpty()) {
                preferences = new Preferences(MainActivity.this);
                preferences.sharedPreferences();
                preferences.setName(username);
                preferences.setPassword(password);
                preferences.setLogin(true);
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                finish();
            }
            else{
                Toast.makeText(this, "Please fill Details", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
