/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.view;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Resource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

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
public class StartScreenView extends UI {

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout();

		final Label titleLbl = new Label("SRS - Smart Reservation System");
		Label logoLbl = new Label();
		Image pic = new Image("src.site.resoruces.images.srs-logo.jpg");
		logoLbl.setIcon((Resource) pic);

		Button btn = new Button("Login");
		btn.addClickListener(e -> {
			// layout.addComponent(new Label(title.getValue()));
			/** TODO */
			SysUserLoginView gui = new SysUserLoginView();
			gui.load((UI) vaadinRequest);
		});

		layout.addComponents(logoLbl, titleLbl, btn);
		layout.setMargin(true);
		layout.setSpacing(true);
		setContent(layout);

	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = StartScreenView.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}