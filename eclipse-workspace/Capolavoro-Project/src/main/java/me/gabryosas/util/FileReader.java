package me.gabryosas.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class FileReader {
    private ArrayList<String> array = new ArrayList<>();

    public FileReader(String path) {
        InputStream inputStream = getClass().getResourceAsStream(path);

        if (inputStream == null) {
            System.err.println("File non trovato: " + path);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            boolean isEmpty = true;

            while ((line = reader.readLine()) != null) {
                isEmpty = false;
                array.add(line);
            }

            if (isEmpty) {
                System.out.println("File vuoto, operazione annullata " + path);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getArray() {
        return this.array;
    }

    @Deprecated
    public void print() {
        for (String s : array) {
            System.out.println(s);
        }
    }

    public boolean isInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}