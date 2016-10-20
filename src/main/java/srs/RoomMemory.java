package srs;

import java.util.List;
import java.util.ArrayList;

public class RoomMemory {
	
	private List<Room> memory;
	
	public RoomMemory() {
		this.memory = new ArrayList<Room>();
	}
	
	//room admin
	public void saveRoom(Room r) throws IllegalArgumentException{
		for(int i=0; i<this.memory.size(); i++) {
			if(!this.memory.get(i).getDescription().equals(r.getDescription()))
				this.memory.add(r);
			else
				throw new IllegalArgumentException();
		}
	}
	
	public void deleteRoom(Room r) {
		for(int i=0; i<this.memory.size(); i++) {
			this.memory.remove(i);
		}
	}
	
	//GETTER
	//room getter
	public String getNames(int i) {
		return this.memory.get(i).getName();
	}
	
	public int getSize(int i) {
		return this.memory.get(i).getSize();
	}
	
	public String getDescription(int i) {
		return this.memory.get(i).getDescription();
	}
	
	//memory getter
	public List<Room> getMemory() {
		return this.memory;
	}
}
