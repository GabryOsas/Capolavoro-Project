package me.gabryosas.util.game;

import java.util.List;

import me.gabryosas.util.Argomento;
import me.gabryosas.util.argomenti.*;

public class Game {
	
	private int vita;
	private int domande;
	private Mafia mafia;
	private Donne donne;
	private String argomento;
	private int index;
	
	public Game() {
		this.vita = 5;
		this.domande = 0;
		this.index = 0;
		this.mafia = new Mafia();
		this.donne = new Donne();
		switch((int)(Math.random() * 2)) {
			case 0:
				this.argomento = "Mafia";
				break;
			case 1:
				this.argomento = "Mafia";
				break;
			default:
				break;
		}
	}
	
	public String getQuestion() {
		return argomento.equalsIgnoreCase("Mafia") ? mafia.getDomande().getDomanda(index) : donne.getDomande().getDomanda(index);
	}
	
	public void next() {
		index += 1;
	}
	
	public List<String> getAnswers() {
		return argomento.equalsIgnoreCase("Mafia") ? mafia.getRisposte().getRisposte(index + 1) : mafia.getRisposte().getRisposte(index + 1);
	}
	
    public Argomento getArgomento() {
    	return argomento.equalsIgnoreCase("Mafia") ? mafia : donne;
    }
    
	public int getLife() {
		return vita;
	}
	public int getIndex() {
		return index;
	}
	public int getDomande() {
		return domande;
	}
 	
	public int removeLife() {
		return vita -= 1;
	}
	
	public int addDomande() {
		return domande += 1;
	}
}
