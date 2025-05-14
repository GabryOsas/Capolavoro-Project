package me.gabryosas.util.object;

import me.gabryosas.util.FileReader;

import java.util.ArrayList;

public class Risposte extends FileReader {
    public Risposte(String path){
        super(path);
    }
    public ArrayList<String> getRisposte(int domanda){
        ArrayList<String> array_new = new ArrayList<>();
        String risposta = "";
        for (int i = 0; i < getArray().size(); i++){
            risposta = getArray().get(i);
            if (!isInt(String.valueOf(risposta.charAt(0))) ||
                    Integer.valueOf(String.valueOf(risposta.charAt(0))) != domanda) continue;
            array_new.add(risposta);
        }
        return array_new;
    }
    public String format(String risposta){
    	risposta = risposta.replaceFirst(String.valueOf(risposta.charAt(0)), " ")
                .replaceFirst("\\s+","")
                .replaceFirst("GIUSTO", " ");
        return risposta;
    }
    public boolean check(int question, int index){
        if (index >= getRisposte(question).size()) return false;
        return getRisposte(question).get(index).endsWith("GIUSTO");
    }
    public boolean check(String risposta){
        return risposta.endsWith("GIUSTO");
    }
    public int getRispostaNumber(int index){
        String risposta = getArray().get(index);
        String value = String.valueOf(risposta.charAt(0));
        return isInt(value) ? Integer.parseInt(value) : -1;
    }
}
