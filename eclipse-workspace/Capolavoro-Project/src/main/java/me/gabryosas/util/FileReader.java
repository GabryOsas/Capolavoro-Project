package me.gabryosas.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class FileReader {
    private ArrayList<String> array = new ArrayList<>();
    public FileReader(String path){
        File file = new File(path);
        if (file.length() == 0) {
            System.out.println("File vuoto, operazione annullata " + path);
            return;
        }
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String out = reader.nextLine();
                array.add(out);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<String> getArray(){
        return this.array;
    }
    @Deprecated
    public void print(){
        for (String s : array) {
            System.out.println(s);
        }
    }
    public boolean isInt(String value){
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}

