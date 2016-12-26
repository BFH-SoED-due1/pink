/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.view.views.helpers;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;

/**
 * @author Nathalie
 *
 */
public class Menu extends CustomComponent implements View {

	private static final long serialVersionUID = 1L;
	private Layout layout;
	private Button bookerBtn;
	private Button roomBtn;
	private Navigator navigator;
	private String CLASSNAME = "menu";

	public Menu(Navigator nav) {

		/* init objects */
		this.navigator = nav;
		this.layout = new HorizontalLayout();
		this.bookerBtn = new Button("booker");
		this.roomBtn = new Button("room");

		/* add to css */
		layout.setPrimaryStyleName(CLASSNAME);
		bookerBtn.setPrimaryStyleName(CLASSNAME + "-button");
		roomBtn.setPrimaryStyleName(CLASSNAME + "-button");

		/* add components to layout */
		layout.addComponent(roomBtn);
		layout.addComponent(bookerBtn);

		/* event handling */
		bookerBtn.addClickListener((Button.ClickListener) event -> navigator.navigateTo("BookerView"));
		roomBtn.addClickListener((Button.ClickListener) event -> navigator.navigateTo("RoomView"));

	}

	public Layout getLayout() {
		return layout;
	}

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
		// TODO Auto-generated method stub

	}
}
