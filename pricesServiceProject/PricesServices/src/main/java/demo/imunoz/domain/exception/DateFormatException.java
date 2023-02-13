package demo.imunoz.domain.exception;

public class DateFormatException extends Exception {

	private static final long serialVersionUID = 1L;

	private static final String ERROR_DATEFORMAT = "An error has occurred in format ";
	private static final String ERROR_PATTERN = ", with pattern ";

	private DateFormatException(String field, String pattern) {
		super(ERROR_DATEFORMAT + field + ERROR_PATTERN + pattern);
	}

	public static DateFormatException of(String field, String pattern) {
		return new DateFormatException(field, pattern);
	}

}