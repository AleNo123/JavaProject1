package org.example.View;

import java.io.*;
public class ConsoleView extends View {
    @Override
    public BufferedReader getReader() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch(RuntimeException e){
            log.error(e.getMessage());
        }
        return reader;
    }
    @Override
    public String getInput(String message){
        printMessage(message);
        String temp = null;
        try {
            temp = bufferedReader.readLine();
        }catch (IOException e){
            log.warn(e.getMessage());
        }
        return temp;
    }
    @Override
    public void printMessage(String message){
        System.out.println(message);
    }
}
