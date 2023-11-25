package org.example.View;

import com.alibaba.fastjson.JSONArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Controller;
import org.example.Note;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class View {
    protected static final Logger log = LogManager.getLogger(View.class);
    protected BufferedReader bufferedReader = getReader();
    public void working(){
        printMessage("Hello and welcome!");
        String temp;
        try{
            printMessage("Possible command: read all, add note, change note, delete note, delete all");
            while (!isNullOrEmpty(temp=bufferedReader.readLine())){
                switch (temp) {
                    case "read all" -> printAll(Controller.getArray());
                    case "add note" -> {
                        String title = getInput("title: ");
                        String text = getInput("text: ");
                        if(Controller.addNote(title,text)) printMessage("Note has been added");
                    }
                    case "change note" -> {
                        String id = getInput("What note to change(id): ");
                        String title = getInput("title: ");
                        String text = getInput("text: ");
                        if(Controller.changeNote(id,title,text)) printMessage("Note has been changed");
                    }
                    case "delete note" -> {
                        String id = getInput("What note to delete(id): ");
                        if(Controller.deleteNote(id)) printMessage("Note has been deleted");
                    }
                    case "delete all" -> {
                        Controller.deleteAllNote();
                        printMessage("Notes have been deleted");
                    }
                    default -> {
                        printMessage("Possible command: read all, add note, change note, delete note, delete all");
                        printMessage("If you want to finish press Enter");
                    }
                }
                Controller.writeJSON();
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
    public abstract BufferedReader getReader();
    public abstract String getInput(String message);
    public abstract void printMessage(String message);
    public void printAll(JSONArray array){
        log.trace("printAll starts");
        for (int i=0;i<array.size();++i){
            printMessage(array.getObject(i, Note.class).toString());
        }
    }
    public static boolean isNullOrEmpty(String str){
        return str == null || str.isEmpty();
    }
}
