package com.SpringBootProject.errorEntites;

import java.time.LocalDateTime;

public class ErrorDetails {
    private LocalDateTime timeStamp;
    private String errorMsg;
    private String details;

    public ErrorDetails(LocalDateTime timeStamp, String errorMsg, String details) {
        this.timeStamp = timeStamp;
        this.errorMsg = errorMsg;
        this.details = details;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public String getDetails() {
        return details;
    }
}
