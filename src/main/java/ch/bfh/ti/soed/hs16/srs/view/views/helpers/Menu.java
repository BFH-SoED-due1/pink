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
 * Created by tambur on 04.12.2016.
 */
public class Menu extends CustomComponent implements View {

	private Layout menu;
	private Button bookerBtn;
	private Button roomBtn;
	private Navigator navigator;
	private String CLASSNAME = "menu";

	public Menu(Navigator nav) {

		/*---------------------------------
		initalize Objects
		---------------------------------*/
		this.navigator = nav;
		this.menu = new HorizontalLayout();
		this.bookerBtn = new Button("booker   ");
		this.roomBtn = new Button("   room");

		/*-------------------------------
		add to css
		-------------------------------*/
		menu.setPrimaryStyleName(CLASSNAME);
		bookerBtn.setPrimaryStyleName(CLASSNAME + "-button");
		roomBtn.setPrimaryStyleName(CLASSNAME + "-button");

		/*-------------------------------
		add Buttons to Layout
		--------------------------------*/
		menu.addComponent(bookerBtn);
		menu.addComponent(roomBtn);

		/*------------------------------
		Event Handling Buttons
		------------------------------*/
		bookerBtn.addClickListener((Button.ClickListener) event -> navigator.navigateTo("BookerView"));
		roomBtn.addClickListener((Button.ClickListener) event -> navigator.navigateTo("RoomView"));

	}

	public Layout getMenu() {
		return menu;
	}

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

	}
}
