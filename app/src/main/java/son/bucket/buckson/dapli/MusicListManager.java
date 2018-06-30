package son.bucket.buckson.dapli;

import java.util.ArrayList;
import java.util.Iterator;

public class MusicListManager {
	private PersonalMusicList my_music_list;
	private ArrayList<PersonalMusicList> others_music_list;
	private Archive my_archives;
	private SpotMusicList group_spot_music_list;
	private boolean do_repeat_playList;

	private Music current_playing_music;
	private Iterator<Music> music_iterator;
    private boolean is_playing;

	// constructor
	public MusicListManager() {
		this.my_music_list = new PersonalMusicList();
		this.others_music_list = new ArrayList<PersonalMusicList>();
		this.group_spot_music_list = new SpotMusicList();
        this.is_playing = false;

        // follow the configuration
		do_repeat_playList = false;
	}
	public MusicListManager(MusicList _my_music_list) {
		this.my_music_list = new PersonalMusicList(_my_music_list);
		this.others_music_list = new ArrayList<PersonalMusicList>();
		this.group_spot_music_list = new SpotMusicList(_my_music_list);
		this.is_playing = false;
		this.music_iterator = my_music_list.get_local_music_list().get_iterator();
		this.current_playing_music = this.music_iterator.next();

		// follow the configuration
		do_repeat_playList = false;
	}
	
	//methods
	public boolean is_playing_music() {return is_playing;}

    public void set_my_music_list(MusicList _my_music_list) {
		this.my_music_list.set_local_music_list(_my_music_list);
	}
	
	public void add_other_music_list(MusicList _other_music_list) {
		PersonalMusicList temp_other_music_list = new PersonalMusicList(_other_music_list);
		others_music_list.add(temp_other_music_list);
		group_spot_music_list.add_music_list_on_spots(_other_music_list);
	}
	
	public MusicList get_my_music_list() {
		return this.my_music_list.get_local_music_list();
	}
	public MusicList get_my_spot_music_list(String spot) { return this.my_music_list.get_trip_spots_music_list(spot); }
	public MusicList get_group_spot_music_list(String spot) { return this.group_spot_music_list.get_spot_music_list(spot); }

	public void set_my_archives(Archive _archives){ this.my_archives = _archives; }
    public Archive get_my_archives() { return my_archives;}
}
