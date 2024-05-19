package com.trongphu.ticketmovie.dto.respone;
/**
 *
 * @author Trong Phu
 */
public class ResponseError extends ResponseData{
    public ResponseError(int status, String message) {
        super(status, message);
    }
}
