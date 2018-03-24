package com.example.antoine.pizzeria;

import android.os.AsyncTask;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class SendOrdering extends AsyncTask<String, String, Void> {

    String ack;
    //Boolean msgReceived = false;

    @Override
    protected Void doInBackground(String... strings) {

        Socket socket = null;

        try {
            socket = new Socket("chadok.info", 9874);
            //socket.setSoTimeout(3000);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer.println(strings[0]);
            ack = reader.readLine();
            if (ack != null) {
                System.out.println("Message du serveur : " + ack);
                publishProgress(ack);
            }
            String end = "";
            while (end.equals("")) {
                end = reader.readLine();
            }
            publishProgress(end);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        PizzeriaMainActivity.txtTabl.setText(values[0]);
    }

    /*
    @Override
    protected void onPostExecute(Void avoid) {
        super.onPostExecute(avoid);
        if (msgReceived) {
            PizzeriaMainActivity.txtTabl.setText(ack);
            msgReceived = false;
        }
    }
    */
}
