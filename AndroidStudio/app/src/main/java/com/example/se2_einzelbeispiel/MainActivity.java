package com.example.se2_einzelbeispiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {


    String sentence;
    String modifiedSentence;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void onClick(View view) throws InterruptedException {

        EditText editText = findViewById(R.id.editText);
        TextView textView = findViewById(R.id.textView2);
        NetworkThread nt = new NetworkThread(editText.getText().toString());
        nt.start();
        nt.join();
        textView.setText(nt.getModifiedSentence());

    }


}
