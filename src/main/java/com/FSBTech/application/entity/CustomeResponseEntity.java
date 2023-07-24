package com.FSBTech.application.entity;


import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

public class CustomeResponseEntity extends ResponseEntity implements Serializable {

private static final long serialVersionUID = 7156526077883281625L;
    public CustomeResponseEntity(Object body, HttpStatusCode status) {
        super(body, status);
    }
}