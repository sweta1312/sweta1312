package com.example.exception;

public class InspectionNotFoundException extends RuntimeException{

    public InspectionNotFoundException(){
        super();
    }

    public InspectionNotFoundException(String message) {
        super(message);
    }

}
