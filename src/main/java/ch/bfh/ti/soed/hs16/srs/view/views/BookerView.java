/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.view.views;

import java.util.List;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;

import ch.bfh.ti.soed.hs16.srs.controller.BookerController;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IBooker;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IBookerController;
import ch.bfh.ti.soed.hs16.srs.view.views.helpers.Menu;

/**
 * @author Nathalie
 *
 */
public class BookerView extends CustomComponent implements View {

	private static final long serialVersionUID = 1L;
	private GridLayout layout;
	private Menu menu;

	private Grid grid = new Grid();
	private IBookerController bookerController;

	public BookerView(Navigator nav) {

		/* init objects */
		this.layout = new GridLayout(6, 6);
		this.menu = new Menu(nav);
		this.bookerController = new BookerController();

		/* add components to layout */
		layout.addComponent(menu.getLayout(), 0, 0, 5, 0);
		grid.setWidth("1000px");
		layout.addComponent(this.grid);

		setCompositionRoot(layout);
		setSizeFull();
	}

	@Override
	public void enter(ViewChangeEvent event) {
		List<IBooker> bookers = this.bookerController.listAllBookers();
		this.grid.setContainerDataSource(new BeanItemContainer<>(IBooker.class, bookers));
	}
}
