package me.gabryosas.util.argomenti;

import me.gabryosas.util.Argomento;

import java.net.URL;

public class Donne extends Argomento {
    public Donne() {
        super(
                getPath("/domande/donne.txt"),
                getPath("/risposte/donne.txt")
        );
    }
}
