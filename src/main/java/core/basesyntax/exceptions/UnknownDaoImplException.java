package core.basesyntax.exceptions;

public class UnknownDaoImplException extends IllegalArgumentException {
    public UnknownDaoImplException(String exceptionMassage) {
        super(exceptionMassage);
    }
}
