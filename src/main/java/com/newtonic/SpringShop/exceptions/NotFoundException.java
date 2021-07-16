package com.newtonic.SpringShop.exceptions;

/**
 * TODO: write you class description here
 *
 * @author Newton
 */

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
