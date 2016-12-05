/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import controller.LogInController;
import model.ISystemUser;

/**
 * @author Nathalie
 *
 */
public class SysUserLoginView {

	private ILogInController loginCtr;
	private List<ISystemUser> sysUsrList;

	public SysUserLoginView() {
		this.sysUsrList = new ArrayList<ISystemUser>();
		this.loginCtr = new LogInController(this.sysUsrList);
	}

	protected void init(VaadinRequest vaadinRequest) {
		VerticalLayout layout = new VerticalLayout();

		TextField loginTxtFld = new TextField();
		PasswordField pwFld = new PasswordField();
		loginTxtFld.setCaption("Enter your login: ");
		pwFld.setCaption("Enter your password: ");

		String login = loginTxtFld.getValue();
		String pw = pwFld.getValue();
		Button loginBtn = new Button("Login");
		loginBtn.addClickListener(e -> {
			this.loginCtr.userLogin(login, pw);
			if (this.loginCtr.isLoggedIn(login)) {
				/** TODO */
			}
		});

		layout.addComponents(loginTxtFld, pwFld, loginBtn);
		layout.setMargin(true);
		layout.setSpacing(true);
		((UI) vaadinRequest).setContent(layout);
	}
}