/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.view.viewInterface;

import java.util.ArrayList;
import java.util.List;
import com.vaadin.ui.UI;

import ch.bfh.ti.soed.hs16.srs.srsInterface.ISystemUser;

/**
 * @author Nathalie
 *
 */
public abstract class LoginViewController {
	private UI mainView;
	private List<ISystemUser> sysUsr;

	public LoginViewController(UI ui, ArrayList<ISystemUser> usrList) {
		this.mainView = ui;
		this.sysUsr = usrList;
	}

	public void load(UI ui) {
		this.mainView = ui;
	}
}
