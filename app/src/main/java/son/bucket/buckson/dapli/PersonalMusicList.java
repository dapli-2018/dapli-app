package prj_class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PersonalMusicList{
	private SpotMusicList trip_spots_music_list;
	private MusicList local_music_list;

	// constructor
	public PersonalMusicList() {
		this.local_music_list = new MusicList();
		this.trip_spots_music_list = new SpotMusicList();
	}
	public PersonalMusicList(MusicList _local_music_list) {
		this.local_music_list = _local_music_list;
		trip_spots_music_list = new SpotMusicList(_local_music_list);
	}
	
	//methods
	public void set_local_music_list(MusicList _local_music_list) {
		this.local_music_list = _local_music_list;
		this.trip_spots_music_list = new SpotMusicList(_local_music_list);
	}
	
	public MusicList get_local_music_list() {return local_music_list;}
	public SpotMusicList get_trip_spots_music_list() { return trip_spots_music_list;}
	public MusicList get_trip_spots_music_list(String spot) { 
		return trip_spots_music_list.get_spot_music_list(spot);
	}
}