package me.gabryosas.util.game;

public enum ObjectUtil {
	BACKGROUND_MUSIC_PATH("C:\\Users\\Utente\\eclipse-workspace\\Capolavoro-Project\\src\\main\\resources\\background-music.wav"),
	MUSIC_PATH("C:\\Users\\Utente\\eclipse-workspace\\Capolavoro-Project\\src\\main\\resources\\music.wav"),
	FINAL_MUSIC_PATH("C:\\Users\\Utente\\eclipse-workspace\\Capolavoro-Project\\src\\main\\resources\\final-question.wav");
	private final String value;
	
	ObjectUtil(String value) {
		this.value = value;
	}
	public String getString() {
		return this.value;
	}
}
