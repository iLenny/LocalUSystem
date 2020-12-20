package com.enkale.usystem.dto;

public class ResponseDTO {
    private ResponseStatus status;
    private String message;
    private String reason;

    public ResponseDTO() {
    }

    public ResponseDTO(ResponseStatus status, String message) {
        this.status = status;
        this.message = message;
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

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
