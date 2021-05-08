package int221.project.project.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
    public static enum ERROR_CODE {
        FILE_ERROR(1000), FILE_NOT_FOUND(1001), FILE_ALREADY_EXIST(1002), PRODUCT_ERROR(2000), PRODUCT_NOT_FOUND(2001),
        PRODUCT_ALREADY_EXIST(2002);

        private int value;

        ERROR_CODE(int value) {
            this.value = value;
        }
    }

    private ERROR_CODE errorCode;
    private String message;
    private LocalDateTime dateTime;

    public ExceptionResponse(ERROR_CODE errorCode, String message, LocalDateTime dateTime) {
        this.errorCode = errorCode;
        this.message = message;
        this.dateTime = dateTime;
    }

    public ERROR_CODE getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
