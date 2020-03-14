package com.example.se2_einzelbeispiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Arrays;

import static java.util.Arrays.sort;

public class MainActivity extends AppCompatActivity {


    String sentence;
    String modifiedSentence;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         editText = findViewById(R.id.editText);
         textView = findViewById(R.id.textView2);


    }

    public void onClickSend(View view) throws InterruptedException { //Für Button Abschicken

        NetworkThread nt = new NetworkThread(editText.getText().toString());
        nt.start();
        nt.join();
        textView.setText(nt.getModifiedSentence());

    }

    public void onClickBerechne(View view){ //Für Button Berechne

     String input = editText.getText().toString();
     char[] array = input.toCharArray();
     int [] mnr = new int[array.length];

     for(int i = 0; i< array.length; i++){
         if(isPrime(Integer.parseInt(String.valueOf(array[i])))==false){
             mnr[i] = Integer.parseInt(String.valueOf(array[i]));
         }else{
             mnr[i] = 99;
         }

     }
     Arrays.sort(mnr);
     String output =  "";
     for(int i = 0; i<mnr.length; i++){
         if (mnr[i] != 99){
             output = output+mnr[i];
         }
     }
     textView.setText(output);
    }



    public boolean isPrime(int x){
        boolean isPrime = true;
        int teiler = 2;

        if(x <= 1 || x %2 == 0){
            isPrime = false;
        }else{
            while (teiler < x){
                if(x % teiler == 0){
                    isPrime = false;
                    break;
                }
                teiler++;
            }
        }
        return isPrime;
    }



}
