/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package view;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.GridLayout;

import controller.LogInController;
import model.ISystemUser;

import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */

@SuppressWarnings("serial")
@Theme("mytheme")
public class SysUsrLogInView extends UI {

	private LogInController loginCtr;
	private List<ISystemUser> sysUsrList;

	public SysUsrLogInView() {
		this.sysUsrList = new ArrayList<ISystemUser>();
		this.loginCtr = new LogInController(this.sysUsrList);
	}

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout vlayout = new VerticalLayout();
		final GridLayout grid = new GridLayout();

		final TextField loginTxtFld = new TextField();
		final PasswordField pwFld = new PasswordField();

		String login = loginTxtFld.getValue();
		String pw = pwFld.getValue();

		loginTxtFld.setCaption("Enter your login: ");
		pwFld.setCaption("Enter your password: ");

		Button loginBtn = new Button("Login");
		loginBtn.addClickListener(e -> {
			this.loginCtr.userLogin(login, pw);
		});

		vlayout.addComponents(loginTxtFld, pwFld, loginBtn);
		vlayout.setMargin(true);
		vlayout.setSpacing(true);

		setContent(vlayout);
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = SysUsrLogInView.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
