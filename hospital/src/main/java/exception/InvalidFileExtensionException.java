package exception;

import javax.naming.directory.InvalidAttributesException;

public class InvalidFileExtensionException extends InvalidAttributesException {
    public InvalidFileExtensionException(String errMsg) {
        super(errMsg);
    }
}
