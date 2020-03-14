package com.example.se2_einzelbeispiel;

import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class NetworkThread extends Thread {


   private String sentence;
   private String modifiedSentence;

    public NetworkThread(String s){
        this.sentence=s;
    }

    public String getModifiedSentence() {
        return modifiedSentence;
    }

    public void run(){
        try {
            Socket clientSocket = new Socket("se2-isys.aau.at", 53212);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outToServer.writeBytes(sentence +'\n');
            this.modifiedSentence = inFromServer.readLine();

            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
