package com.trongphu.ticketmovie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Trong Phu on 5/22/2024
 *
 * @author Trong Phu
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private ErrorResponse setData(Exception e, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(new Date());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setPath(request.getDescription(false).replace("uri", ""));
        errorResponse.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorResponse.setMessage(e.getMessage());
        if (e instanceof MethodArgumentNotValidException) {
            String message = e.getMessage();
            int start = message.lastIndexOf("[");
            int end = message.lastIndexOf("]");
            message = message.substring(start + 1, end - 1);
            errorResponse.setMessage(message);
        }
        return errorResponse;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerValidationException(Exception e, WebRequest request) {
        System.out.println("------> Đã bắt được exception");
        return setData(e, request);
    }
    @ExceptionHandler({SQLException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerSQLExeption(Exception e, WebRequest request) {
        System.out.println("------> Đã bắt được exception SQL");
        return setData(e, request);
    }

    @ExceptionHandler({ExistsDataException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerValidationException(ExistsDataException e, WebRequest request) {
        System.out.println("------> Đã bắt được exception trùng data");
        return setData(e, request);
    }
    @ExceptionHandler({PermissionDenyException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerValidationException(PermissionDenyException e, WebRequest request) {
        System.out.println("------> Đã bắt được exception admin");
        return setData(e, request);
    }

    @ExceptionHandler({DataNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerValidationException(DataNotFoundException e, WebRequest request) {
        System.out.println("------> Đã bắt được exception notfound");
        return setData(e, request);
    }


}
