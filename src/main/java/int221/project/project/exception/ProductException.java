package int221.project.project.exception;

public class ProductException extends RuntimeException {
    ExceptionResponse.ERROR_CODE errorCode;

    public ProductException(ExceptionResponse.ERROR_CODE errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ExceptionResponse.ERROR_CODE getErrorCode() {
        return this.errorCode;
    }

}
