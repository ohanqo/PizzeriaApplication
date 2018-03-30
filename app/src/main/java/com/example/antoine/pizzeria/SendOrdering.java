package com.example.antoine.pizzeria;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class SendOrdering extends AsyncTask<String, String, Void> {

    String ack;
    //Boolean msgReceived = false;


    /**
     * Envoie & reçois les messages via socket
     * @param strings : Message/Commande
     * @return
     */
    @Override
    protected Void doInBackground(String... strings) {

        Socket socket = null;

        try {
            // On définie un nouveau socket
            socket = new Socket("chadok.info", 9874);
            // On définie un flux permettant d'envoyer un message via le socket
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            // On définie un flux permettant de reçevoir les messages via socket
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // On envoie le message passé par paramètre lors de execute()
            writer.println(strings[0]);
            // Lis le dernier message du serveur
            ack = reader.readLine();
            if (ack != null) {
                System.out.println("Message du serveur : " + ack);
                publishProgress(ack);
            }
            // Attend la réponse du serveur
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
        // Modifie le titre et y affiche le message du serveur
        PizzeriaMainActivity.txtTabl.setText(values[0]);

        // Si le message indique qu'une pizza est prête, on l'ajoute à la liste correspondante
        if(values[0].contains("prête")) {
            PizzeriaMainActivity.readyPizzas.add(values[0]);
        }
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
