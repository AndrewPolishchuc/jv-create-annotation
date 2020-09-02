package core.basesyntax.exceptions;

public class MissingAnnotationException extends RuntimeException {
    public MissingAnnotationException(String exceptionMassage) {
        super(exceptionMassage);
    }
}
