/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.view.views.helpers;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

/**
 * @author Nathalie
 *
 */
public class Footer {

	private HorizontalLayout footerLayout;

	public Footer(String enterprise, String city, String country) {
		this.footerLayout = new HorizontalLayout();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("© 2015 by ");
		stringBuilder.append(enterprise);
		stringBuilder.append(", ");
		stringBuilder.append(city);
		stringBuilder.append(", ");
		stringBuilder.append(country);
		TextField footer = new TextField(stringBuilder.toString());

		footerLayout.addComponents(footer);
	}

	public HorizontalLayout getFooterLayout() {
		return this.footerLayout;
	}
}
