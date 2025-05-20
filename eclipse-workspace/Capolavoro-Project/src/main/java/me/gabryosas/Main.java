package me.gabryosas;


import me.gabryosas.util.argomenti.Mafia;
import me.gabryosas.util.game.MainGUI;
import me.gabryosas.util.game.ObjectUtil;
import me.gabryosas.util.game.SoundUtil;


/* IMPORTANTE - GabryOsas
    - Le domande iniziano sempre da 1 IMPORTANTE
    - Mentre le risposte iniziano sempre da 0
    - PATH music C:\Users\Utente\eclipse-workspace\Capolavoro-Project\src\main\resources\music.wav
 */

public class Main {
	
	public static boolean[] OPEN = {true, false};
	
    public static void main(String[] args){
    	MainGUI game = new MainGUI();
    	game.setVisible(true);
        SoundUtil.playSound(ObjectUtil.BACKGROUND_MUSIC_PATH.getString());
    }
}