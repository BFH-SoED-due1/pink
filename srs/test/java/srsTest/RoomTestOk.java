package srsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import srs.Room;

public class RoomTestOk {

	@Test
	public void testRoomName() {
		String name = "N.321";
		int size = 30;
		String description = "This is a description!";
		String newName = "N.522";
		
		Room room = new Room(size, name, description);
		assertEquals(room.getName(), name);
		
		room.setName(newName);
		assertEquals(room.getName(), newName);
	}
	
	@Test
	public void testSize() {
		String name = "N.321";
		int size = 30;
		String description = "This is a description!";
		int newSize = 36;
		
		Room room = new Room(size, name, description);
		assertEquals(room.getSize(), size);
		
		room.setSize(newSize);
		assertEquals(room.getSize(), newSize);
	}
	
	@Test
	public void testDescription() {
		String name = "N.321";
		int size = 30;
		String description = "This is a description!";
		String newDescription = "This is a new description!";
		
		Room room = new Room(size, name, description);
		assertEquals(room.getDescription(), description);

		room.setDescription(newDescription);
		assertEquals(room.getDescription(), newDescription);
	}
}
