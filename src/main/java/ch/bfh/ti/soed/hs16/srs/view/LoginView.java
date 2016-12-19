/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.view;

import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.ti.soed.hs16.srs.controller.LogInController;
import ch.bfh.ti.soed.hs16.srs.srsInterface.ILogInController;
import ch.bfh.ti.soed.hs16.srs.srsInterface.ISystemUser;

/**
 * @author Nathalie
 *
 */
public class LoginView {

	private UI ui;
	private ILogInController loginCtr;
	private List<ISystemUser> sysUsr;

	public LoginView(UI u) {
		this.ui = u;
		this.loginCtr = new LogInController(this.sysUsr);
	}

	public void load(UI myUI) {
		final VerticalLayout layout = new VerticalLayout();
		final Image logo = new Image(
				"D:/Nathalie/Documents/SW-Dev/Java/Eclipse/git/srs-pink/src/site/resources/images");
		Button enterBtn = new Button("Enter Smart Reservation System");
		enterBtn.addClickListener(e -> {

		});

		layout.addComponents(logo, enterBtn);
		layout.setMargin(true);
		layout.setSpacing(true);

		myUI.setContent(layout);

	}
}

/**
 * final VerticalLayout layout = new VerticalLayout();
 * 
 * final TextField loginTxtFld = new TextField(); final PasswordField pwFld =
 * new PasswordField();
 * 
 * loginTxtFld.setCaption("Enter your login: "); pwFld.setCaption("Enter your
 * passowrd: ");
 * 
 * Button button = new Button("Login"); button.addClickListener(e -> { // TODO
 * });
 * 
 * layout.addComponents(loginTxtFld, pwFld, button); layout.setMargin(true);
 * layout.setSpacing(true);
 * 
 * setContent(layout);
 */