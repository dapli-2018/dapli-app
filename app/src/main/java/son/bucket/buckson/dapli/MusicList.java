package com.example.shindonggil.dapli_app;

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
}