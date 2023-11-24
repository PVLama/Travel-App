package com.example.btlandroid_travelapp.model;

import java.util.List;

public class ModelTopPlaces {
    private boolean success;
    private String message;
    private List<TopPlaces> result;

    public ModelTopPlaces(boolean success, String message, List<TopPlaces> result) {
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

    public List<TopPlaces> getResult() {
        return result;
    }

    public void setResult(List<TopPlaces> result) {
        this.result = result;
    }
}
