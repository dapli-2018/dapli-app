package com.example.shindonggil.dapli_app;

public class Music {
	// Field
	private String title;
	private int index;
	private String spot;
	
	public Music(String _title, int _index, String _spot) {
		this.title = _title;
		this.index = _index;
		this.spot = _spot;
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
		this.spot = spot;
	}
}
