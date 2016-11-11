package controller.exceptions;

public class BookerNotFoundException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public BookerNotFoundException(String m) {
		super(m);
	}
}
