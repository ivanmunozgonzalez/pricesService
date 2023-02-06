package demo.imunoz.domain.exception;

public class MapperException extends Exception {

    private static final long serialVersionUID = 1L;

    private static final String ERROR_MAPPER = "An error has occurred in mapper ";

    private MapperException(String mapper) {
	super(ERROR_MAPPER + mapper);
    }

    public static MapperException of(String mapper) {
	return new MapperException(mapper);
    }

}
