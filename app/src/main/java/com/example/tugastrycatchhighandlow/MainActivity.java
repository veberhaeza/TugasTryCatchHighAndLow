package com.example.tugastrycatchhighandlow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1; //untuk batas sampai 20
    }

    int randomNumber;

    public void randomNumberGenerator() { //untuk repeat game
        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }


    public void onSubmit(View view) {
        String message = "";
        try {
            EditText editTextNumber = (EditText) findViewById(R.id.edt_number);
            int res = Integer.parseInt(editTextNumber.getText().toString());

            if (res < randomNumber) {
                message = "Lower !!!";
            } else if (res > randomNumber) {
                message = "Higher !!!";
            } else {
                message = "You Got Me !!!";
                randomNumberGenerator(); //perualangan sampai menemukan hasil
            }
        } catch (NumberFormatException e) { //text tidak boleh kosong
            message = "cannot be empty";
        } finally {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
}