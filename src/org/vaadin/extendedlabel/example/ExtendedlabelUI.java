package org.vaadin.extendedlabel.example;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

public class ExtendedlabelUI extends UI {
	@Override
	public void init(VaadinRequest request) {
		Label label = new Label("Hello Vaadin user");
		addComponent(label);
	}

}
