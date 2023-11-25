package org.example;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.View.ConsoleView;
import org.example.View.View;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
//        System.out.println("Hello and welcome!");//Для видимости настройки
//        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))){
//            JSONArrayHandler handler = new JSONArrayHandler();
////            handler.printAll();
//            String temp;
//            System.out.println("Possible command: read all, add note, change note, delete note, delete all");
//            while (!isNullOrEmpty(temp=bufferedReader.readLine())){
//                switch (temp) {
//                    case "read all" -> handler.printAll();
//                    case "add note" -> handler.addNote(Note.createNote());
//                    case "change note" -> {
//                        System.out.print("What note to change(id): ");
//                        handler.changeNote(Integer.parseInt(bufferedReader.readLine()));
//                    }
//                    case "delete note" -> {
//                        System.out.print("What note to delete(id): ");
//                        handler.deleteNote(Integer.parseInt(bufferedReader.readLine()));
//                    }
//                    case "delete all" -> handler.deleteAllNote();
//                    default -> {
//                        System.out.println("Possible command: read all, add note, change note, delete note, delete all");
//                        System.out.println("If you want to finish press Enter");
//                    }
//                }
//                handler.writeJSON();
//            }
//        } catch (IOException e) {
//            logger.error(e.getMessage());
//        }
        Controller controller = new Controller();
        View view = new ConsoleView();
        view.working();
    }
    public static boolean isNullOrEmpty(String str){
        return str == null || str.isEmpty();
    }
}