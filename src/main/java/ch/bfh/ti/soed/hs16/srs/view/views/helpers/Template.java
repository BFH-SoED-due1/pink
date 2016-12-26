/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.view.views.helpers;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;

/**
 * @author Nathalie
 *
 */
public class Template extends CustomComponent implements View {

	private static final long serialVersionUID = 1L;
	// private Navigator navigator;
	private Layout layout;
	private String CLASSNAME = "template";

	public Template(Navigator nav) {

		/* init objects */
		// this.navigator = nav;
		this.layout = new HorizontalLayout();

		/* add to css */
		this.layout.setPrimaryStyleName(CLASSNAME);

		/* add components to layout */

		/* event handling */
	}

	public Layout getLayout() {
		return this.layout;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}
}
