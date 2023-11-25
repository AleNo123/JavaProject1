package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Note { //Model
    private String text;
    private String title;
    private Date date;
    public Note(String title, String text, Date date) {
        this.text = text;
        this.title = title;
        this.date = date;
    }
    public Note() {
    }
    public String getText() {
        return text;
    }
    public String getTitle() {
        return title;
    }
    public Date getDate() {
        return date;
    }
    public Note(String text, Date date) {
        this.title = "Noname";
        this.text = text;
        this.date = date;
    }
    public void setText(String text){
        this.text = text;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDate(Date date) {
        this.date = date;
    }
//    public static Note createNote() {
//        Note note = null;
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
//            System.out.print("title: ");
//            String title = bufferedReader.readLine();
//            System.out.println(title);
//            System.out.print("text: ");
//            String text = bufferedReader.readLine();
//            note = new Note(title,text,new Date());
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return note;
//    }
    @Override
    public String toString(){
        return "Title: "+title+
                "\n\t"+ text+
                "\nLast changes: "+(new SimpleDateFormat("k:mm dd.MM.yyyy")).format(date)+"\n";
    }
}
