package com.example.lab5;

import android.os.AsyncTask;

import java.io.PrintWriter;
import java.io.StringWriter;

public class DataLoader extends AsyncTask<String, Void, String> {

    protected String doInBackground(String... params) {
        try {
            return com.example.lab5.DataManager.getRateFromECB(params[0]);
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            return sw.toString();
        }
    }
}