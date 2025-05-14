package me.gabryosas.util.argomenti;

import me.gabryosas.util.Argomento;

public class Donne extends Argomento {
    private static final String PATH_DOMANDE = "C:\\Users\\Utente\\eclipse-workspace\\Capolavoro-Project\\src\\main\\resources\\domande\\donne.txt";
    private static final String PATH_RISPOSTE = "C:\\Users\\Utente\\eclipse-workspace\\Capolavoro-Project\\src\\main\\resources\\risposte\\donne.txt";
    public Donne() {
        super(PATH_DOMANDE, PATH_RISPOSTE);
    }
}
