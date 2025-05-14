package me.gabryosas.util;

import me.gabryosas.util.object.Domande;
import me.gabryosas.util.object.Risposte;

public class Argomento {
    protected Domande domande;
    protected Risposte risposte;
    public Argomento(String path_domande, String path_risposte){
        this.domande = new Domande(path_domande);
        this.risposte = new Risposte(path_risposte);
    }
    public Domande getDomande(){
        return this.domande;
    }
    public Risposte getRisposte(){
        return this.risposte;
    }
}
