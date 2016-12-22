/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.view.views;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Nathalie
 *
 */
public class OverView extends CustomComponent implements View {

	// View instance variables
	private Navigator navigator;
	private Layout layout;

	public OverView(Navigator nav) {
		Label viewName = new Label("SRS - System-Overview");

		// Init view Objects
		this.layout = new VerticalLayout();
		this.navigator = nav;

		Button systemBtn = new Button("OverView");
		Button bookerBtn = new Button("Bookers");
		Button resBtn = new Button("Reservations");
		Button roomBtn = new Button("Rooms");
		Button sysUsrBtn = new Button("SRS-Users");
		Button logBtn = new Button("Login-Logout");

		// Performed actions
		systemBtn.addClickListener(e -> this.navigator.navigateTo("overView"));
		bookerBtn.addClickListener(e -> this.navigator.navigateTo("bookerView"));
		resBtn.addClickListener(e -> this.navigator.navigateTo("reservationView"));
		roomBtn.addClickListener(e -> this.navigator.navigateTo("roomView"));
		sysUsrBtn.addClickListener(e -> this.navigator.navigateTo("sysUsrView"));
		logBtn.addClickListener(e -> this.navigator.navigateTo("loginView"));

		// add all to layout
		this.layout.addComponents(viewName, systemBtn, bookerBtn, resBtn, roomBtn, sysUsrBtn, logBtn);
	}

	public Layout getLayout() {
		return this.layout;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener.
	 * ViewChangeEvent)
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
	}
}
