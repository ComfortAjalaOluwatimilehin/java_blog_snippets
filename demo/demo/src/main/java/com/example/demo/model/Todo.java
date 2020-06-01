package com.example.demo.model;
import java.util.regex.Pattern;
import java.util.UUID;

public class Todo {
    private final UUID id;
    private  String title;
    private boolean isComplete = false;

    public Todo(UUID id,  String title, boolean isComplete){
        this.id = id;
        this.setTitle(title);
        this.setComplete(isComplete);
    }

    public String getTitle() {
        return title;
    }
    public boolean getIsComplete(){
        return isComplete;
    }
    public UUID getId() {
        return id;
    }
    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static boolean validateTodo(String title){
        if(title == null) {
            return false;
        }
        boolean isValid = true;
        String pattern = "\\w+";
        Pattern p = Pattern.compile(pattern);
       return p.matcher(title).find();
    }
}
