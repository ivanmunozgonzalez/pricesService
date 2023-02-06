package demo.imunoz.domain.exception;

public class PersistenceException extends Exception {

    private static final long serialVersionUID = 1L;

    private final String entity;
    private final String field;

    private static final String ERROR_ENTITY = "An error has occurred in entity ";
    private static final String ERROR_ENTITY_FIELD = ", in the field ";

    public PersistenceException(String entity, String field) {
	super(ERROR_ENTITY + entity + ERROR_ENTITY_FIELD + field);
	this.entity = entity;
	this.field = field;
    }

    public String getEntity() {
	return entity;
    }

    public String getField() {
	return field;
    }
}
