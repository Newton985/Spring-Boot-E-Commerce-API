package com.newtonic.SpringShop.exceptions;

/**
 * TODO: write you class description here
 *
 * @author Root
 */

public class AuthFailureException extends  RuntimeException {
    public  AuthFailureException(String message){
        super(message);
    }

}
