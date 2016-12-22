/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.view.views;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;

import ch.bfh.ti.soed.hs16.srs.view.views.helpers.Menu;

/**
 * @author Nathalie
 *
 */
public class RoomView extends CustomComponent implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GridLayout layout;
	private Menu menu;

	public RoomView(Navigator nav) {

		/*---------------------------------
		initalize Objects
		---------------------------------*/
		this.layout = new GridLayout(6, 6);
		this.menu = new Menu(nav);

		/*---------------------------------
		add objects to root layout
		---------------------------------*/
		layout.addComponent(menu.getMenu(), 0, 0, 5, 0);

		setCompositionRoot(layout);
		setSizeFull();

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
