package me.gabryosas.util.game;

public enum ObjectUtil {
	BACKGROUND_MUSIC_PATH("/background-music.wav"),
	MUSIC_PATH("/music.wav"),
	FINAL_MUSIC_PATH("/final-question.wav");

	private final String value;

	ObjectUtil(String value) {
		this.value = value;
	}

	public String getString() {
		return this.value;
	}
}