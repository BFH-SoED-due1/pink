/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.view.views;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.ti.soed.hs16.srs.view.views.helpers.Footer;
import ch.bfh.ti.soed.hs16.srs.view.views.helpers.Header;

/**
 * @author Nathalie
 *
 */
public class LoginView extends CustomComponent implements View {

	private static final long serialVersionUID = 1L;
	private VerticalLayout layout;
	private Button btn;
	private TextField loginFld;
	private PasswordField pwFld;
	private Footer footer;
	private Header header;

	public LoginView(Navigator nav) {

		/* init objects */
		this.layout = new VerticalLayout();
		this.btn = new Button("Login");
		this.loginFld = new TextField("username");
		this.pwFld = new PasswordField("password");
		this.footer = new Footer("BFH", "Biel-Bienne", "Schweiz");
		this.header = new Header();
		this.layout.addComponents(this.loginFld, this.pwFld, this.btn);

		/* add to css */
		this.layout.setPrimaryStyleName("rootLogin");
		this.btn.setStyleName("buttonLogin");

		/* add components to layout */
		// this.layout.addComponent(this.header.getHeaderLayout());
		this.layout.addComponents(this.loginFld, this.pwFld, this.btn, this.footer.getFooterLayout());
		setCompositionRoot(layout);

		/* event handling */
		this.btn.addClickListener((Button.ClickListener) clickEvent -> {
			// handle userlogin
			nav.navigateTo("RoomView");
		});
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}
}
