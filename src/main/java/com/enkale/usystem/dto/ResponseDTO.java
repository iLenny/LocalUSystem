package com.enkale.usystem.dto;

import java.time.LocalDateTime;

public class ResponseDTO {
    private ResponseStatus status;
    private String message;
    private String reason;
    private LocalDateTime timeStamp;

    public ResponseDTO() {
        this.timeStamp = LocalDateTime.now();
    }

    public ResponseDTO(ResponseStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public ResponseDTO(ResponseStatus status, String message, String reason) {
        super();
        this.status = status;
        this.message = message;
        this.reason = reason;
    }

    public ResponseDTO(ResponseStatus status, String message, String reason, LocalDateTime timeStamp) {
        this.status = status;
        this.message = message;
        this.reason = reason;
        this.timeStamp = timeStamp;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public ResponseDTO setStatus(ResponseStatus status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseDTO setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public ResponseDTO setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public ResponseDTO setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", reason='" + reason + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
