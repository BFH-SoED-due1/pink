/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.view.views.helpers;

import com.vaadin.ui.HorizontalLayout;

/**
 * @author Nathalie
 *
 */
public class Header {

	private HorizontalLayout headerLayout;

	@SuppressWarnings("deprecation")
	public Header() {
		this.headerLayout = new HorizontalLayout();
	}

	public HorizontalLayout getFooterLayout() {
		return this.headerLayout;
	}
}
