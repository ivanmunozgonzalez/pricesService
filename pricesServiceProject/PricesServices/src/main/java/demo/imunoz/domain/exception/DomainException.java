package demo.imunoz.domain.exception;

public class DomainException extends Exception {

    private static final long serialVersionUID = 1L;

    private static final String ERROR_DOMAIN = "An error has occurred in domain ";
    private static final String ERROR_DOMAIN_FIELD = ", in the field ";

    private DomainException(String domain, String field) {
	super(ERROR_DOMAIN + domain + ERROR_DOMAIN_FIELD + field);
    }

    public static DomainException of(String domain, String field) {
	return new DomainException(domain, field);
    }

}
