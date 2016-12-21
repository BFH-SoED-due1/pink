/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.view.views.helpers;

import java.sql.Date;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

/**
 * @author Nathalie
 *
 */
public class Footer {

	private HorizontalLayout footerLayout;

	@SuppressWarnings("deprecation")
	public Footer(String enterprise, String city, String country) {
		this.footerLayout = new HorizontalLayout();
		Date date = new Date(0);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("© by ");
		stringBuilder.append(date.getDate());
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
