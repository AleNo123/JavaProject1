package org.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;

public class Controller {
    protected static final Logger log = LogManager.getLogger(Controller.class);
    private static final String path="src/main/resources/note.json";
    private static final JSONArray array =JSON.parseArray(readJSON());
    public static void writeJSON(){
        log.trace("writeJSON starts");
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(JSON.toJSONString(array));
            fileWriter.flush();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
    public static void deleteAllNote(){
        log.trace("deleteAllNote starts");
        array.clear();
    }
    public static JSONArray getArray() {
        return array;
    }
    public static boolean deleteNote(String id){
        log.trace("deleteNote starts");
        try {
            int index = Integer.parseInt(id);
            array.remove(index);
            return true;
        } catch (Exception e){
            log.warn(e.getMessage());
            return false;
        }
    }
    public static boolean addNote(String title,String text) {
        log.trace("addNote starts");
        Note note = null;
        if(isNullOrEmpty(text)&&isNullOrEmpty(title)){ return false;}
        else if(isNullOrEmpty(title)){  note = new Note(text,new Date());}
        else{  note = new Note(title,text,new Date());}
        array.add(note);
        return true;
    }
    public static boolean changeNote(String id,String title,String text){
        log.trace("changeNote starts");
        try {
            Note note = array.getObject(Integer.parseInt(id), Note.class);
            if(isNullOrEmpty(text)&&isNullOrEmpty(title)){ return false;}
            else if(isNullOrEmpty(title)){  note.setText(text);}
            else if(isNullOrEmpty(text)){
                note.setTitle(title);
            } else {
                note.setText(text);
                note.setTitle(title);
            }
            note.setDate(new Date());
            return true;
        }catch (Exception e){
            log.warn(e.getMessage());
            return false;
        }
    }

    public static String readJSON() {
        log.trace("readJSON starts");
        StringBuilder jsonString=new StringBuilder();
        int letter;
        try (FileReader reader = new FileReader("src/main/resources/note.json")){
            while ((letter = reader.read()) != -1) {
                jsonString.append((char) letter);
            }
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return jsonString.toString();
    }
    public static boolean isNullOrEmpty(String str){
        return str == null || str.isEmpty();}
}

