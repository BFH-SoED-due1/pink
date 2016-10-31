package srsTest;

import static org.junit.Assert.*;
import org.junit.Test;
import srs.Room;

public class RoomTest {

	@Test
	public void testRoomName() {
		String name = "N.321";
		int size = 30;
		String description = "This is a description!";
		String newName = "N.522";

		Room room = new Room(size, name, description);
		assertEquals(name, room.getName());

		room.setName(newName);
		assertEquals(newName, room.getName());
	}

	@Test
	public void testSize() {
		String name = "N.322";
		int size = 30;
		String description = "This is a description!";
		int newSize = 36;

		Room room = new Room(size, name, description);
		assertEquals(size, room.getSize());

		room.setSize(newSize);
		assertEquals(newSize, room.getSize());
	}

	@Test
	public void testDescription() {
		String name = "N.323";
		int size = 30;
		String description = "This is a description!";
		String newDescription = "This is a new description!";

		Room room = new Room(size, name, description);
		assertEquals(description, room.getDescription());

		room.setDescription(newDescription);
		assertEquals(newDescription,   room.getDescription());
	}
}