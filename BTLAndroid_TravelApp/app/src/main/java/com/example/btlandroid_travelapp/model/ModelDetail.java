package com.example.btlandroid_travelapp.model;

import java.util.List;

public class ModelDetail {
    private boolean success;
    private String message;
    private List<Detail> result;

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

    public List<Detail> getResult() {
        return result;
    }

    public void setResult(List<Detail> result) {
        this.result = result;
    }
}
