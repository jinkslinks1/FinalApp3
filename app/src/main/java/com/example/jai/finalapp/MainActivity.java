package com.example.jai.finalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etMovieName;
    TextView tvDisplay;
    MyDBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMovieName = (EditText) findViewById(R.id.etMovieName);
        tvDisplay = (TextView) findViewById(R.id.tvDisplay);
        // we pass 4 variables and the constuctor is expecting 4
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }

    public void printDatabase() {
        //convert contents of database to string
        String dbString = dbHandler.databaseToString();

        tvDisplay.setText(dbString);

    }

    public void addMovie(View view) {
        //create object of movies class passing the movie name we input and converting to string
        Movies movies = new Movies(etMovieName.getText().toString());
        dbHandler.addMovies(movies);
        //print content everytime new movie is added
        printDatabase();


    }

    public void deleteMovie(View view) {
        // string to store input from user in teh edittext
        String inputMovie = etMovieName.getText().toString();
        // pass string to dbHandler deleteMovies() method
        dbHandler.deleteMovies(inputMovie);
        //print database once deleted
        printDatabase();
    }

    public void editMovie(View view) {
        String inputMovie = etMovieName.getText().toString();
        dbHandler.editMovies(inputMovie);
        printDatabase();
    }

    public void playGame(View view) {



        //go to second activity
        Intent intent = new Intent(this, Main2Activity.class);


        startActivity(intent);
        finish();

    }
}
