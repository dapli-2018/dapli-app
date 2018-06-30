package son.bucket.buckson.dapli;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class getJsonObjectTask extends AsyncTask<JSONObject, Void, JSONObject> {
    /*
    Usage :
        getJsonObjectTask task = new getJsonObjectTask();
        task.execute(JSONObject param);
        param : JSON type
         'URL' : String, Server url
         'METHOD' : String, POST / GET / DELETE
         'IS_HOST' : Boolean, HOST / GUEST
         'DATA' : JSONObject, Data to send
     */
    private static final int READ_TIMEOUT = 3000;
    private static final int CONNECT_TIMEOUT = 3000;

    @Override
    protected JSONObject doInBackground(JSONObject... params) {
        HttpURLConnection CONNECTION = null;
        OutputStream out_stream = null;
        InputStream in_stream = null;
        ByteArrayOutputStream byteArray_out_stream = null;
        URL url = null;
        String url_string = null;
        String method = null;

        try {
            url_string = (String) params[0].get("URL") + (String)params[0].get("URL_TYPE");
            method = (String) params[0].get("METHOD");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            url = new URL(url_string);
            Log.e("get task", "execute task");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try{
            CONNECTION = (HttpURLConnection)url.openConnection();
            CONNECTION.setDoOutput(true);
            CONNECTION.setDoInput(true);
            CONNECTION.setReadTimeout(READ_TIMEOUT);
            CONNECTION.setConnectTimeout(CONNECT_TIMEOUT);
            CONNECTION.setRequestMethod(method);
            CONNECTION.setRequestProperty("Cache-Control", "no-cache");
            CONNECTION.setRequestProperty("Content-Type", "application/json");
            CONNECTION.setRequestProperty("Accept", "application/json");

            out_stream = CONNECTION.getOutputStream();
            out_stream.write(params[0].get("DATA").toString().getBytes());
            out_stream.flush();

            int res_from_server = CONNECTION.getResponseCode();
            Log.i("JSON RES", String.format("%d",res_from_server));
            // if( res_from_server == HttpURLConnection.HTTP_OK){
            if( res_from_server == 201){
                StringBuilder builder = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(CONNECTION.getInputStream()))){
                    String line;
                    while ((line = reader.readLine()) != null){
                        builder.append(line);
                    }
                } catch(IOException e){
                    e.printStackTrace();
                }

                return new JSONObject(builder.toString());
            } else{
                Log.e("JSON read error", "Connection Error");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            CONNECTION.disconnect();
        }
        return null;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject){
        Log.i("Json read: ", jsonObject.toString());
    }
}