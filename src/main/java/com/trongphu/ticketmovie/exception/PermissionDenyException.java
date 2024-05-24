package com.trongphu.ticketmovie.exception;

/**
 * Created by Trong Phu on 5/21/2024
 *
 * @author Trong Phu
 */
public class PermissionDenyException extends Exception{
    public PermissionDenyException(String message){
        super(message);
    }
}
