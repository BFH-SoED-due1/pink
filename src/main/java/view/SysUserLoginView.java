/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import controller.LogInController;
import model.ISystemUser;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

/**
 * @author Nathalie
 *
 */
public class SysUserLoginView {

	private ILogInController loginCtr;
	private List<ISystemUser> sysUsrList;

	public SysUserLoginView(ILogInController controller) {
		this.sysUsrList = new ArrayList<ISystemUser>();
		this.loginCtr = new LogInController(this.sysUsrList);
	}

	public void load(UI myUI) {
		final VerticalLayout layout = new VerticalLayout();

		final TextField loginTxtFld = new TextField();
		final PasswordField pwFld = new PasswordField();

		String login = loginTxtFld.getValue();
		String pw = pwFld.getValue();
		Button loginBtn = new Button("Login");

		loginTxtFld.setCaption("Enter your login: ");
		pwFld.setCaption("Enter your password: ");
		loginBtn.addClickListener(e -> {
			this.loginCtr.userLogin(login, pw);
			if (this.loginCtr.isLoggedIn(login)) {
				myUI.setContent(new SysUserOverView().displayOverView());
			}
		});

		layout.addComponents(loginTxtFld, pwFld, loginBtn);
		layout.setMargin(true);
		layout.setSpacing(true);
		myUI.setContent(layout);
	}
}
