package srs;

import java.sql.Time;
import java.util.Date;

public class Reservation {
	
	private Room room;
	private Date date;
	private Time from, until;
	private Booker booker;
	
	public Reservation(Room r, Date d, Time from, Time until, Booker b) {
		this.room = r;
		this.date = d;
		this.from = from;
		this.until = until;
		this.booker = b;
	}

	//Setter
	public void setRoom(Room r) {
		this.room = r;
	}

	public void setDate(Date d) {
		this.date = d;
	}

	public void setFrom(Time from) {
		this.from = from;
	}

	public void setUntil(Time until) {
		this.until = until;
	}

	public void setBooker(Booker b) {
		this.booker = b;
	}
	
	//Getter
	public Room getRoom() {
		return room;
	}

	public Date getDate() {
		return date;
	}

	public Date getFrom() {
		return from;
	}

	public Date getUntil() {
		return until;
	}

	public Booker getBooker() {
		return booker;
	}	
}

