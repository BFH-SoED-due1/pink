package srsTest;

import static org.junit.Assert.*;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;
import srs.Room;

public class RoomTest {
	
	//methods form room-class
	@Test
	public void testRoomSize() {
		Room r = new Room(100, "N.311", "RoomN.311");
		assertEquals(100, r.getSize());
	}
	
	@Test
	public void testRoomName() {
		Room r = new Room(1000, "N.311", "RoomN.311");
		assertEquals("N.311", r.getName());
	}

	@Test
	public void testRoomDescripton() {
		Room r = new Room(1000, "N.311", "RoomN.311");
		assertEquals("RoomN.311", r.getDescription());
	}
	
//	@Test
//	public void testXy() {
//		fail("Not yet implemented");
//	}
}
