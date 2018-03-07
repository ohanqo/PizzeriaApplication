package com.example.antoine.pizzeria;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class SendOrdering extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... voids) {

        Socket socket = null;
        BufferedReader reader = null;

        try {
            socket = new Socket("chadok.info", 9874);
            //reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("90montagnarde");
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
}
