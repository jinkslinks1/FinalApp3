package com.example.jai.finalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class Main3Activity extends AppCompatActivity {

    EditText etName ;
    EditText etPassword ;
    String username = "admin" ;
    String password = "password" ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        etName = (EditText)findViewById(R.id.etShow);
        etPassword = (EditText)findViewById(R.id.etPassword) ;

    }

    public void login(View view) {



            //go to second activity
            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra("Name", etName.getText().toString());
            //intent.putExtra("age", 35);
            startActivity(intent);
            finish();

    }

}
