////////////////////////////////////////////////////////////////////////////////
// checkstyle: Checks Java source code for adherence to a set of rules.
// Copyright (C) 2001-2016 the original author or authors.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
////////////////////////////////////////////////////////////////////////////////
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

	// Setter
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

	// Getter
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
