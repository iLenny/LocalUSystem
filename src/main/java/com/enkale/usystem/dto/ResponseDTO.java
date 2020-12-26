package com.enkale.usystem.dto;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ResponseDTO {
    private ResponseStatus status;
    private String message;
    private String reason;
    private String timeStamp;

    public ResponseDTO() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss z");
        this.timeStamp = ZonedDateTime.now().format(formatter);
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

    public ResponseDTO(ResponseStatus status, String message, String reason, String timeStamp) {
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

    public String getTimeStamp() {
        return timeStamp;
    }

    public ResponseDTO setTimeStamp(String timeStamp) {
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
