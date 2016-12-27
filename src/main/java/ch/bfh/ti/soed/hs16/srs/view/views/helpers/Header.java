/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.view.views.helpers;

import java.io.File;

import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Nathalie
 *
 */
public class Header {

	private VerticalLayout layout;

	@SuppressWarnings("deprecation")
	public Header() {

		/* init objects */
		this.layout = new VerticalLayout();
		Label txtLbl = new Label();
		txtLbl.setCaption("SRS - Smart Reservation System");

		// find application in directory
		String basePath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
		// image as file resource
		FileResource fileResource = new FileResource(new File(basePath + "\\VAADIN\\themes\\mytheme\\srsLogo.jpg"));
		Image pic = new Image("", fileResource);

		/* add components to layout */
		this.layout.addComponents(pic, txtLbl);
	}

	public VerticalLayout getHeaderLayout() {
		return this.layout;
	}
}
