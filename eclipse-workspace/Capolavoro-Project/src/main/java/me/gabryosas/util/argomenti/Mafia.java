package me.gabryosas.util.argomenti;

import me.gabryosas.util.Argomento;

public class Mafia extends Argomento {
    private static final String PATH_DOMANDE = "C:\\Users\\Utente\\eclipse-workspace\\Capolavoro-Project\\src\\main\\resources\\domande\\mafia.txt";
    private static final String PATH_RISPOSTE = "C:\\Users\\Utente\\eclipse-workspace\\Capolavoro-Project\\src\\main\\resources\\risposte\\mafia.txt";
    public Mafia() {
        super(PATH_DOMANDE, PATH_RISPOSTE);
    }
}
