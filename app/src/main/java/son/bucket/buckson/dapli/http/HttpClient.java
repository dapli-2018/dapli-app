package com.example.shindonggil.daummap;

import android.nfc.Tag;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class HttpClient {
    private HttpURLConnection CONNECTION = null;
    private OutputStream out_stream = null;
    private InputStream in_stream = null;
    private ByteArrayOutputStream byteArray_out_stream = null;
    private static final String HOST_URL = "http://127.0.0.1";
    private static final String HOST_PORT = "1234";
    private static final int READ_TIMEOUT = 3000;
    private static final int CONNECT_TIMEOUT = 3000;

    private boolean is_connected = false;

    public HttpClient() throws IOException {
        URL connect_url = new URL(HOST_URL);
        CONNECTION = (HttpURLConnection)connect_url.openConnection();

        // set CONNECTION
        CONNECTION.setReadTimeout(READ_TIMEOUT);
        CONNECTION.setConnectTimeout(CONNECT_TIMEOUT);
        CONNECTION.setDoInput(true);
        CONNECTION.setDoOutput(true);
        CONNECTION.setRequestMethod("GET");
        CONNECTION.setRequestProperty("Accept", "application/json");
        CONNECTION.setRequestProperty("Context_Type","application/json");

        // connect to server
        CONNECTION.connect();

        in_stream = CONNECTION.getInputStream();
        out_stream = CONNECTION.getOutputStream();
        is_connected = true;
    }

    public boolean is_connected_with_server(){
        return is_connected;
    }

    public boolean send_json_data(JSONObject data) throws IOException{
        out_stream.write(data.toString().getBytes());
        out_stream.flush();
        int response_code = CONNECTION.getResponseCode();
        if( response_code == HttpURLConnection.HTTP_OK){
            // SUCCESS
            // CASES: RECEIVE MUSIC LIST ...
            return true;
        }
        else {
            // FAIL
            return false;
        }
    }

    public boolean receive_json_data() throws IOException, JSONException {
        int recv_data_length = 0;
        byte[] byteBuffer = new byte[1024];
        byte[] byteData = null;

        while(( recv_data_length = in_stream.read(byteBuffer, 0, byteBuffer.length)) != -1){
            byteArray_out_stream.write(byteBuffer,0, recv_data_length);
        }
        byteData = byteArray_out_stream.toByteArray();
        String response_from_server = new String(byteData);

        JSONObject response_json = new JSONObject(response_from_server);
        if( !(boolean) response_json.get("result")) return false;

        String res_command = (String) response_json.get("COMMAND");
        JSONObject res_data = (JSONObject) response_json.get("DATA");

        return true;
    }
}
