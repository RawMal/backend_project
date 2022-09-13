package com.example.backend_project.models;

public class Reply {

    private String message;

    private boolean victorious;

    public Reply (String message, boolean victorious){

        this.message = message;
        this.victorious = victorious;
    }

    public Reply(){
        
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isVictorious() {
        return victorious;
    }

    public void setVictorious(boolean victorious) {
        this.victorious = victorious;
    }
}
