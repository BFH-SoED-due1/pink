/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.view.viewInterface;

import com.vaadin.ui.Button;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Nathalie
 *
 */
public class LoginView {
	private LoginViewController loginView;

	public LoginView(LoginViewController loginView) {
		this.loginView = loginView;
	}

	public void load(UI ui) {
		final VerticalLayout layout = new VerticalLayout();
		final TextField loginFld = new TextField();
		final PasswordField pwFld = new PasswordField();
		Button btn = new Button("Login");

		loginFld.setCaption("Login");
		pwFld.setCaption("Password");

		btn.addClickListener(e -> {
			this.loginView.load(ui);
		});
	}
}
