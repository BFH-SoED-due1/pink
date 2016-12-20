/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.view.views.helpers;

import java.io.File;

import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.TextField;

/**
 * @author Nathalie
 *
 */
public class Header {

	private HorizontalLayout headerLayout;

	public Header() {
		this.headerLayout = new HorizontalLayout();
		TextField header = new TextField();

		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
		// path for jpg
		FileResource resource = new FileResource(new File(basepath + "VAADIN/themes/mythemes/srs-logo.jpg"));
		// pic
		Image logo = new Image();
		this.headerLayout.setSpacing(true);

		this.headerLayout.addComponents(header, logo);
	}

	public HorizontalLayout getFooterLayout() {
		return this.headerLayout;
	}
}
