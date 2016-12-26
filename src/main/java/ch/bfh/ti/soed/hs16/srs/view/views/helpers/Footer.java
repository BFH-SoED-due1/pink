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
	private TextField txtFld;

	public Footer(String enterprise, String city, String country) {

		/* init objects */
		this.footerLayout = new HorizontalLayout();
		StringBuilder stringBuilder = new StringBuilder();

		/* create String */
		stringBuilder.append("© 2015 by ");
		stringBuilder.append(enterprise);
		stringBuilder.append(", ");
		stringBuilder.append(city);
		stringBuilder.append(", ");
		stringBuilder.append(country);

		/* add to textfield */
		this.txtFld = new TextField(stringBuilder.toString());

		/* add components to layout */
		this.footerLayout.addComponents(this.txtFld);
	}

	public HorizontalLayout getFooterLayout() {
		return this.footerLayout;
	}
}
