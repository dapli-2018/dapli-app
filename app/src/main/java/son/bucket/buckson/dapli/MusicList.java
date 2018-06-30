package son.bucket.buckson.dapli;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class MusicList {
	ArrayList<Music> music_list;
	
	// constructor
	public MusicList(ArrayList<Music> _music_list) {
		music_list = _music_list;
	}
	public MusicList(JSONObject _music_list){
	    music_list = new ArrayList<Music>();
	    String music_list_Str = _music_list.toString();
	    music_list_Str.substring(1,music_list_Str.length()-1); // cut [ ]
        String[] music_str_array = music_list_Str.split(",");
        for( String music_str : music_str_array) {
            music_str.substring(1, music_str.length() - 1);
            music_str.split(",");
            Music entry = new Music("title", -1, "artist", "spot");
            music_list.add(entry);
        }
    }
	public MusicList() {music_list = new ArrayList<Music>();}
	
	//methods
	public ArrayList<Music> get_music_list(){return music_list;}
	public int get_music_list_size(){return music_list.size();}
	
	public void add_music(Music _music){
		if( !music_list.contains(_music))
			this.music_list.add(_music);
	}
	
	public boolean remove_music(Music _music){
	    /*
            Music temp = null;
            for(Iterator<Music> iter = this.music_list.iterator();!iter.hasNext();){
                temp = iter.next();
                if(temp.get_title() == _music.get_title()) break;
            }

            return music_list.remove(temp);
	     */
	    return music_list.remove(_music);
	}
	
	public Iterator<Music> get_iterator(){
		return music_list.iterator();
	}
	
	public ArrayList<String> get_music_name_list(){
		Iterator<Music> iter = music_list.iterator();
		ArrayList<String> music_name_list = new ArrayList<String>();
		
		while( iter.hasNext()){
			Music entry = (Music)iter.next();
			music_name_list.add(entry.get_title());
		}
		
		return music_name_list;
	}
	
	public String get_json_music_list() {
		Iterator<Music> iter = music_list.iterator();
		String json_music_list= "[";
		Music entry = (Music)iter.next();
		
		if(entry != null){ json_music_list = get_json_stringify_music(entry);}
		
		while( iter.hasNext()) {
			entry = (Music)iter.next();
			json_music_list += "," + get_json_stringify_music(entry);
		}

		return json_music_list + "]";
	}
	
	private String get_json_stringify_music(Music _entry) {
		return String.format("[\"%s\",\"%s\",\"%s\",\"%s\"]", _entry.get_title(), _entry.get_artist(), _entry.get_spot(), _entry.get_do_play());
	}
}