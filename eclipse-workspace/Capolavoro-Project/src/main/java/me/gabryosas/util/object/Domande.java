package me.gabryosas.util.object;


import me.gabryosas.util.FileReader;

public class Domande extends FileReader {
    public Domande(String path){
        super(path);
    }
    public String getDomanda(int index){
        String domanda = getArray().get(index);
        domanda = domanda.replace(domanda.charAt(0), ' ')
                .replaceFirst("\\s+","");
        return domanda;
    }
    public int getDomandaNumber(int index){
        String domanda = getArray().get(index);
        String value = String.valueOf(domanda.charAt(0));
        return isInt(value) ? Integer.parseInt(value) : -1;
    }
}
