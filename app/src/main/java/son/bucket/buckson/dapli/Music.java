package prj_class;

public class Music {
	// Field
	private String title;
	private int index;
	private String spot;
	private boolean do_play;
	
	public Music(String _title, int _index, String _spot) {
		this.title = _title;
		this.index = _index;
		this.spot = _spot;
		this.do_play = false;
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
		return do_play;
	}

	public void set_do_play(boolean _do_play) {
		this.do_play = _do_play;
	}
}
