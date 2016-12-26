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
import com.vaadin.ui.VerticalLayout;

/**
 * @author Nathalie
 *
 */
public class Header {

	private VerticalLayout layout;

	public Header() {
		this.layout = new VerticalLayout();
		String basePath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
		System.out.println(basePath);
		FileResource resource = new FileResource(new File(basePath));
		Image pic = new Image("srsLogo.jpg", resource);
		this.layout.addComponent(pic);
	}

	public VerticalLayout getHeaderLayout() {
		return this.layout;
	}
}
