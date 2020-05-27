package com.example.demo.model;

import java.util.UUID;

public class Todo {
    private final UUID id;
    private final String title;
    private boolean isComplete = false;

    public Todo(UUID id, String  title,  boolean isComplete){
        this.title = title;
        this.isComplete  = isComplete;
        this.id = id;
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
}
