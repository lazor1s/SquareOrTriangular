package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void onClick(View view){
        EditText number = (EditText) findViewById(R.id.editTextNumber);
        String message;
        Log.i("Log: ", "button pressed");

        if(number.getText().toString().isEmpty()){

            message = "please enter a number";

        } else {
            squareOrTri myNumber = new squareOrTri();

            myNumber.number = Integer.parseInt(number.getText().toString());
            message = number.getText().toString();
        if(myNumber.square()&& myNumber.isTriangular()){
            message +=" is square and triangle";
        }else if (myNumber.square()){
            message +=" is square";
        }else if (myNumber.isTriangular()){
            message += " is triangular";

        }else{
            message += " is nether";
        }

        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();


    }

    class squareOrTri {
        int number;

        public boolean square() {
            double sq = Math.sqrt(number);
            double sqtotal = sq - Math.floor(sq);

            if (sqtotal == 0) {
                return true;
            } else {
                return false;
            }

        }

        public boolean isTriangular() {

            int x = 1;

            int triangularNumber = 1;

            while (triangularNumber < number) {

                x++;
                triangularNumber = triangularNumber + x;
            }

            if (triangularNumber == number) {
                return true;
            } else {
                return false;
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}