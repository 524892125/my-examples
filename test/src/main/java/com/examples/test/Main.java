package com.examples.test;

import com.examples.word.controller.Common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("a.txt"));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        Common.show("asd");
        System.out.println("Hello World!");
    }
}
