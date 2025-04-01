package com.example.desafio_tecnico_backend.response.defaultResponse;

import java.util.List;

public class DefaultResponse {
    public Status status;
    public Object data;
    public List<String> errors;

    public DefaultResponse(int code,String message,Object data){
        this.status = new Status(code,message);
        this.data = data;
    }

    public DefaultResponse(int code,String message,List<String> errors){
        this.status = new Status(code,message);
        this.errors = errors;
    }
}
