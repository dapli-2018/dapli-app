package son.bucket.buckson.dapli;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class NetworkTask {
    /*
        JSONObject
         'URL' : String, Server url
         'METHOD' : String, POST / GET / DELETE
         'URL_TYPE' :/group/host/, /group/guest/
         'DATA' : JSONObject, Data to send
    */
    private getJsonObjectTask task;
    private static final String HOST_URL = "http://172.16.17.4:8018";

    public NetworkTask(){
        this.task = new getJsonObjectTask();
    }

    /*
    Send
        'songs' : [[title, artist, album]...]
        'title' : playList title
        'author' : playList author
        'content' : playList content
        'tag' : playList tag
    Receive
        'id' : musicList id value
        'key' : authentication number(4 digits)
    */
    public JSONObject send_music_list(MusicList music_list, String _url_type)
            throws JSONException, ExecutionException, InterruptedException {
        JSONObject send_data = new JSONObject();
        String data = String.format("{\"songs\":\"%s\"," +
                "\"title\":\"%s\", " +
                "\"author\":\"%s\", " +
                "\"content\": \"%s\", " +
                "\"tag\":\"%s\"", music_list.get_json_music_list(), "testTitle","testAuthor",
                                                                    "testContent","testTag");
        send_data.put("URL",HOST_URL);
        send_data.put("METHOD", "POST");
        send_data.put("URL_TYPE", _url_type);
        send_data.put("DATA", music_list.get_json_music_list());

        return (JSONObject)task.execute(send_data).get();
    }

    /*
    Send
        'id' : playList id value
    Receive(None)
        status code only
    */
    public void delete_group_music_playList(int playList_unique_id, String _url_type)
            throws JSONException, ExecutionException, InterruptedException {
        JSONObject send_data = new JSONObject();
        String data = String.format("{\"id\":%d}", playList_unique_id);

        send_data.put("URL",HOST_URL);
        send_data.put("METHOD", "DELETE");
        send_data.put("URL_TYPE", _url_type);
        send_data.put("DATA", data);

        JSONObject result_from_server = task.execute(send_data).get();
    }

    /*
    Send
        'id' : playList id value
    Receive
        music list status
        'songs' : [[title, is_on_playlist, is_played]...]
     */
    public MusicList syncronize_group_music_playList(int playList_unique_id, boolean is_host, String _url_type)
            throws JSONException, ExecutionException, InterruptedException {
        JSONObject send_data = new JSONObject();
        String data = String.format("{\"id\":%d}", playList_unique_id);
        MusicList ret_music_list = new MusicList();

        send_data.put("URL",HOST_URL);
        if(is_host)
            send_data.put("METHOD", "GET");
        else
            send_data.put("METHOD","PUT");
        send_data.put("URL_TYPE", _url_type);
        send_data.put("DATA", data);

        // Need to revise
        JSONObject result_from_server = task.execute(send_data).get();
        return new MusicList((JSONObject)result_from_server);
    }

    /*
    Send
        'writer' : writer_name
    Receive
        'feedlist' : feed list - string
     */
    public FeedList get_feed_list(User user, String _url_type) throws JSONException, ExecutionException, InterruptedException {
        JSONObject send_data = new JSONObject();
        String data = String.format("{writer:\"%s\"}", user.get_user_name());
        FeedList ret_feedList= null;

        send_data.put("URL",HOST_URL);
        send_data.put("METHOD", "GET");
        send_data.put("URL_TYPE", _url_type);
        send_data.put("DATA", data);

        JSONObject result_from_server = task.execute(send_data).get();
        return new FeedList((JSONObject)result_from_server);
    }

    /*
    Send
        'writer' : writer_name
    Receive
        'feedlist' : archive - string
     */
    public Archive get_user_archives(User user, String _url_type) throws JSONException, ExecutionException, InterruptedException {
        JSONObject send_data = new JSONObject();
        String data = String.format("{writer:\"%s\"}", user.get_user_name());
        Archive ret_achieves= new Archive();

        send_data.put("URL",HOST_URL);
        send_data.put("METHOD", "GET");
        send_data.put("URL_TYPE", _url_type);
        send_data.put("DATA", data);

        JSONObject result_from_server = task.execute(send_data).get();
        return new Archive((JSONObject)result_from_server);
    }

    /*
    Send
        'id' : playList id value
    Receive
        'key' : grouping key
     */
    public int get_group_key(int id, String _url_type) throws JSONException, ExecutionException, InterruptedException {
        JSONObject send_data = new JSONObject();
        String data = String.format("{\"id\":%d}", id);

        send_data.put("URL", HOST_URL);
        send_data.put( "METHOD", "GET");
        send_data.put("URL_TYPE", _url_type);
        send_data.put("DATA", data);

        JSONObject result_from_server = task.execute(send_data).get();
        return (int) result_from_server.get("key");
    }

    /*
    Send
        'id' : playList id value
    Receive
        'key' : grouping key
     */
    public int require_group_key(int id, String _url_type) throws JSONException, ExecutionException, InterruptedException {
        JSONObject send_data = new JSONObject();
        String data = String.format("{\"id\":%d}", id);

        send_data.put("URL", HOST_URL);
        send_data.put( "METHOD", "POST");
        send_data.put("URL_TYPE", _url_type);
        send_data.put("DATA", data);

        JSONObject result_from_server = task.execute(send_data).get();
        return (int) result_from_server.get("key");
    }

    /*
    Send
        'key' : group key
    Receive(None)
        status code only
     */
    public int delete_group_key(int group_key, String _url_type) throws JSONException, ExecutionException, InterruptedException {
        JSONObject send_data = new JSONObject();
        String data = String.format("{\"key\":%d}", group_key);

        send_data.put("URL", HOST_URL);
        send_data.put( "METHOD", "GET");
        send_data.put("URL_TYPE", _url_type);
        send_data.put("DATA", data);

        JSONObject result_from_server = task.execute(send_data).get();
        return (int) result_from_server.get("key");
    }

    /*
    Send
        'id' : playList id
    Receive
        'image' : [URL...]
     */
    public String[] get_playList_images(int playList_id, String _url_type) throws JSONException, ExecutionException, InterruptedException {
        JSONObject send_data = new JSONObject();
        String data = String.format("{\"id\":%d}", playList_id);

        send_data.put("URL", HOST_URL);
        send_data.put( "METHOD", "GET");
        send_data.put("URL_TYPE", _url_type);
        send_data.put("DATA", data);

        JSONObject result_from_server = task.execute(send_data).get();
        return (String[]) result_from_server.get("image");
    }

    /*
    Send
        'id' : playList id
    Receive
        ARRAY : [['title','artist','album','is_on_playlist','is_played']...]
    */
    public JSONObject get_playList_contents(int playList_id, String _url_type)
            throws JSONException, ExecutionException, InterruptedException {
        JSONObject send_data = new JSONObject();
        String data = String.format("{\"id\":\"%d\"", playList_id);

        send_data.put("URL",HOST_URL);
        send_data.put("METHOD", "GET");
        send_data.put("URL_TYPE", _url_type);
        send_data.put("DATA", data);

        return (JSONObject)task.execute(send_data).get();
    }}