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

import ch.bfh.ti.soed.hs16.srs.controller.RoomController;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IRoom;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IRoomController;
import ch.bfh.ti.soed.hs16.srs.view.views.helpers.Menu;

/**
 * @author Nathalie
 *
 */
public class RoomView extends CustomComponent implements View {

	private static final long serialVersionUID = 1L;
	private GridLayout layout;
	private Menu menu;

	private Grid grid = new Grid();
	private IRoomController roomController;

	public RoomView(Navigator nav) {

		/* init objects */
		this.layout = new GridLayout(6, 6);
		this.menu = new Menu(nav);
		this.roomController = new RoomController();

		/* add components to layout */
		this.layout.addComponent(menu.getLayout(), 0, 0, 5, 0);
		this.grid.setWidth("1000px");
		this.layout.addComponent(this.grid);

		setCompositionRoot(this.layout);
		setSizeFull();
	}

	@Override
	public void enter(ViewChangeEvent event) {
		List<IRoom> rooms = this.roomController.listAllRooms();
		this.grid.setContainerDataSource(new BeanItemContainer<>(IRoom.class, rooms));
	}
}
