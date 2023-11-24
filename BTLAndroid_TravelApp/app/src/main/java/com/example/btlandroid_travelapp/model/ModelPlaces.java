package com.example.btlandroid_travelapp.model;

import java.util.List;

public class ModelPlaces {
    private boolean success;
    private String message;
    private List<Places> result;

    public ModelPlaces(boolean success, String message, List<Places> result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Places> getResult() {
        return result;
    }

    public void setResult(List<Places> result) {
        this.result = result;
    }
}
