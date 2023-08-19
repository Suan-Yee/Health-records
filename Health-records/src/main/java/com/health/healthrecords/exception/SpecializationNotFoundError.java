package com.health.healthrecords.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SpecializationNotFoundError extends RuntimeException{

    private String resourceName;
    private String  fieldValue;

    public SpecializationNotFoundError(String resourceName,String fieldValue){
        super(String.format("%s not found with specialization [%s]",resourceName,fieldValue));
        this.resourceName = resourceName;
        this.fieldValue = fieldValue;
    }
}
