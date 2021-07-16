package com.newtonic.SpringShop.exceptions;

/**
 * TODO: write you class description here
 *
 * @author Newton
 */

public class AppException {

    public AppException(String message){
        this.message = message;
    }

    private String message;

    @Override
    public String toString() {
        return "{\"message\": \""+ this.message +"\", \"status\":\"error\"}";
    }
}
