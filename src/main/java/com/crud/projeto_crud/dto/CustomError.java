package com.crud.projeto_crud.dto;

import java.time.Instant;

public class CustomError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;

    public CustomError(Instant timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }

    //
//            "timestamp": "2025-03-11T21:22:24.392+00:00"
//            "status": 500,
//            "error": "Internal Server Error",
//            "path": "/clients/12"


}
