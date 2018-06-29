package com.example.shindonggil.daummap;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkCall extends AsyncTask<String, Void, String> {
    String result = null;
    String apiserver = "address/apiserver";

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        //publishProgress();
        String result=null;
        switch(params[0]){
            case "GET" :
                result = getClient(params);
                break;
            case "POST" :
                break;
        }
        return result;
    }

    @Override
    protected void onPostExecute(String aVoid){
        super.onPostExecute(aVoid);
    }

    protected String getClient(String... params){
        try {
            URL url =new URL(apiserver+params[1]);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            conn.setReadTimeout(1000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod(params[0]);
            conn.setDoInput(true);
            //conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setDefaultUseCaches(false);

            String cookie  = conn.getHeaderField("Set-Cookie");

            InputStream is = conn.getInputStream();

            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            String line;

            conn.disconnect();

            while((line = reader.readLine())!=null) {
                builder.append(line + "\n");
            }
            result = builder.toString();
        }catch (IOException io){
            io.printStackTrace();
        }
        return result;
    }

    protected void postClient(String... params){
        try {
            URL url =new URL(apiserver+params[1]);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            conn.setRequestMethod(params[0]);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setReadTimeout(1000);
            conn.setConnectTimeout(15000);

            OutputStream os = conn.getOutputStream();

            StringBuilder builder = new StringBuilder();
            String line;
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}