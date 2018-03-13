package com.example.antoine.pizzeria;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class SendOrdering extends AsyncTask<Void, Void, Void> {

    private int table;
    private String pizza;

    public SendOrdering(int table, String pizza) {
        this.table = table;
        this.pizza = pizza;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        Socket socket = null;
        BufferedReader reader = null;

        try {
            socket = new Socket("chadok.info", 9874);
            //reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            String msg = this.table + this.pizza;
            writer.println(msg);
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
