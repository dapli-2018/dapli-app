package son.bucket.buckson.dapli;

public class Music {
	// Field
	private String title, artist, spot;
	private int index;
	private boolean is_on_playList, is_played;
	
	public Music(String _title, int _index, String _artist, String _spot) {
		this.title = _title;
		this.index = _index;
		this.spot = _spot;
		this.artist = _artist;
		this.is_on_playList = true;
		this.is_played = false;
	}

	public String get_artist() {
		return artist;
	}
	public void get_artist(String _artist) {
		this.artist = _artist;
	}

	public String get_title() {
		return title;
	}
	public void set_title(String _title) {
		this.title = _title;
	}

	public int get_index() {
		return index;
	}
	public void set_index(int _index) {
		this.index = _index;
	}

	public String get_spot() {
		return spot;
	}
	public void set_spot(String _spot) {
		this.spot = _spot;
	}

	public boolean get_do_play() {
		return is_played;
	}
	public void set_do_play(boolean _do_play) {
		this.is_played = _do_play;
	}

	public boolean get_is_on_playList() { return is_on_playList;}
	public void set_is_on_playList(boolean _is_on_playList) {this.is_on_playList = _is_on_playList;}
}
