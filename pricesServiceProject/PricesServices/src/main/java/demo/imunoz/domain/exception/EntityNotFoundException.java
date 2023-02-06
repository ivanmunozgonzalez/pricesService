package demo.imunoz.domain.exception;

public class EntityNotFoundException extends PersistenceException {

    private static final long serialVersionUID = 1L;

    private static final String ERROR_ENTITY = "An error has occurred, entity ";
    private static final String NOT_FOUND = " not found.";

    private EntityNotFoundException(String entity) {
	super(entity, null);
    }

    public static EntityNotFoundException of(String entity) {
	return new EntityNotFoundException(entity);
    }

    @Override
    public String getMessage() {
	return ERROR_ENTITY + this.getEntity() + NOT_FOUND;
    }
}
