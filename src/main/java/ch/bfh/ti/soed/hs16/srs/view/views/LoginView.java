/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.view.views;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.ti.soed.hs16.srs.model.SystemUser;
import ch.bfh.ti.soed.hs16.srs.srsInterface.ISystemUser;
import ch.bfh.ti.soed.hs16.srs.view.views.helpers.Footer;
import ch.bfh.ti.soed.hs16.srs.view.views.helpers.Header;

/**
 * @author Nathalie
 *
 */
public class LoginView {

	private ISystemUser sysUsr;
	private VerticalLayout layout;
	private Button btn;
	private TextField loginFld;
	private PasswordField pwFld;
	private Footer footer;
	private Header header;

	public LoginView(Navigator nav) {
		/** Initalize objects */
		this.sysUsr = new SystemUser();
		this.layout = new VerticalLayout();
		this.btn = new Button("Login");
		this.loginFld = new TextField();
		this.pwFld = new PasswordField();
		this.footer = new Footer("BFH", "Biel-Bienne", "Schweiz");
		this.header = new Header();
		this.layout.addComponents(this.loginFld, this.pwFld, this.btn);
		pwHandling(nav);
	}

	public void pwHandling(Navigator nav) {

	}
}
