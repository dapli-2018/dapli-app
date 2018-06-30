package son.bucket.buckson.dapli;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class Archive {
    ArrayList<MusicList> archive;

    public Archive(){}
    public Archive(JSONObject _archive) throws JSONException {
        this.archive = new ArrayList<MusicList>();

        JSONArray musicList_array = (JSONArray)_archive.get("result");
        for(int i = 0; i < musicList_array.length(); i++){
            JSONObject json_musicList = (JSONObject) musicList_array.get(i);
            this.archive.add(new MusicList(json_musicList));
        }
    }

    public void set_archive(ArrayList<MusicList> _archive){ this.archive = _archive; }
    public ArrayList<MusicList> get_archive() { return this.archive;}
}
