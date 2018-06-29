package prj_class;

import java.util.ArrayList;
import java.util.Iterator;

public class MusicList {
	ArrayList<Music> music_list;
	
	// constructor
	public MusicList(ArrayList<Music> _music_list) {
		music_list = _music_list;
	}
	public MusicList() {
		music_list = new ArrayList<Music>();
	}
	
	//methods
	public ArrayList<Music> get_music_list(){return music_list;}
	public int get_music_list_size(){return music_list.size();}
	
	public void add_music(Music _music){
		if( !music_list.contains(_music))
			this.music_list.add(_music);
	}
	
	public boolean remove_music(Music _music){return music_list.remove(_music);}
	
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
		String json_music_list= "";
		Music entry = (Music)iter.next();
		
		if(entry != null){ json_music_list = get_json_stringify_music(entry);}
		
		while( iter.hasNext()) {
			entry = (Music)iter.next();
			json_music_list += "," + get_json_stringify_music(entry);
		}
		
		return json_music_list;
	}
	
	private String get_json_stringify_music(Music _entry) {
		return String.format("\"title\":\"%s\",\"do_play\":%b",
				_entry.get_title(), _entry.get_do_play());
	}
}