package com.example.shindonggil.dapli_app;

import java.util.ArrayList;

public class MusicListManager {
	private PersonalMusicList my_music_list;
	private ArrayList<PersonalMusicList> others_music_list;
	private SpotMusicList group_spot_music_list;
	
	// constructor
	public MusicListManager() {
		this.my_music_list = new PersonalMusicList();
		this.others_music_list = new ArrayList<PersonalMusicList>();
		group_spot_music_list = new SpotMusicList();
	}
	public MusicListManager(MusicList _my_music_list) {
		this.my_music_list = new PersonalMusicList(_my_music_list);
		this.others_music_list = new ArrayList<PersonalMusicList>();
		group_spot_music_list = new SpotMusicList(_my_music_list);
	}
	
	//methods
	public void set_my_music_list(MusicList _my_music_list) {
		this.my_music_list.set_local_music_list(_my_music_list);
	}
	
	public void add_other_music_list(MusicList _other_music_list) {
		PersonalMusicList temp_other_music_list = new PersonalMusicList(_other_music_list);
		others_music_list.add(temp_other_music_list);
		group_spot_music_list.add_music_list_on_spots(_other_music_list);
	}
}
