/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.view;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import ch.bfh.ti.soed.hs16.srs.db.DataGenerator;
import ch.bfh.ti.soed.hs16.srs.view.views.BookerView;
import ch.bfh.ti.soed.hs16.srs.view.views.LoginView;
import ch.bfh.ti.soed.hs16.srs.view.views.RoomView;

/**
 * @author Nathalie
 *
 */

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@SuppressWarnings("serial")
@Theme("mytheme")
public class MyUI extends UI {

	private Navigator navigator;

	static {
		DataGenerator.create();
	}

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		this.navigator = new Navigator(this, this);
		this.navigator.addView("", new LoginView(this.navigator));
		this.navigator.addView("BookerView", new BookerView(this.navigator));
		this.navigator.addView("RoomView", new RoomView(this.navigator));
	}

	@Override
	public Navigator getNavigator() {
		return this.navigator;
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
