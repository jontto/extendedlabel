package org.vaadin.addon.extendedlabel.demo;

import org.vaadin.addon.extendedlabel.ExtendedLabel;
import org.vaadin.addon.extendedlabel.client.ui.ExtendedContentMode;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class DemoUI extends UI {

	VerticalLayout contentRoot;
	
	@Override
	protected void init(VaadinRequest request) {
		
		contentRoot = new VerticalLayout();
		
		setContent(contentRoot);

		
		ExtendedLabel exl = new ExtendedLabel(ExampleSyntax.getMarkdownSample(), ExtendedContentMode.MARKDOWN);
		contentRoot.addComponent(exl);
	}


}
