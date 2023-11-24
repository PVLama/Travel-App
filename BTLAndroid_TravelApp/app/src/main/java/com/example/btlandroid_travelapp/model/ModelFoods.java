package com.example.btlandroid_travelapp.model;

import java.util.List;

public class ModelFoods {
    private boolean success;
    private String message;
    private List<Foods> result;

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

    public List<Foods> getResult() {
        return result;
    }

    public void setResult(List<Foods> result) {
        this.result = result;
    }
}
