package son.bucket.buckson.dapli;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SpotMusicList {
	private HashMap<String, MusicList> trip_spots_music_list;
	
	// constructor
	public SpotMusicList() {
		trip_spots_music_list = new HashMap<String, MusicList>();
	}
	public SpotMusicList(MusicList _music_list) {
		trip_spots_music_list = new HashMap<String, MusicList>();
		add_music_list_on_spots(_music_list);
	}
	
	//methods
	public void add_music_list_on_spots(MusicList music_list) {
		Iterator iter = music_list.get_iterator();
		while( iter.hasNext()){
			Music entry = (Music)iter.next();
			String spot = entry.get_spot();
			if( !trip_spots_music_list.containsKey(spot)) {
				MusicList temp_music_list = new MusicList();
				temp_music_list.add_music(entry);
				
				trip_spots_music_list.put(spot, temp_music_list);
			}
			else { 
				trip_spots_music_list.get(spot).add_music(entry);
			}
		}
	}

	public MusicList get_spot_music_list(String spot) {
		return this.trip_spots_music_list.get(spot);
	}
	
	public Set<String> get_spots(){
		return this.trip_spots_music_list.keySet();
	}
}
