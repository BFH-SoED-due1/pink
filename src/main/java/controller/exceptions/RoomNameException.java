package controller.exceptions;

public class RoomNameException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public RoomNameException(String m) {
		super(m);
	}
}
