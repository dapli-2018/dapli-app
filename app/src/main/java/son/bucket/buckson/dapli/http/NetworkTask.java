package com.example.shindonggil.daummap;

import android.os.AsyncTask;
import java.io.IOException;

public class NetworkTask extends AsyncTask<Void, Void, String> {
    private HttpClient http_client;

    public NetworkTask() throws IOException {
        String result;
        http_client = new HttpClient();
        result = http_client.request(url,values);
    }
}
