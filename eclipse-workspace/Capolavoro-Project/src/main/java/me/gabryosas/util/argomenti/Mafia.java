package me.gabryosas.util.argomenti;

import me.gabryosas.util.Argomento;

public class Mafia extends Argomento {
    public Mafia() {
        super(
                getPath("/domande/mafia.txt"),
                getPath("/risposte/mafia.txt")
        );
    }
}
