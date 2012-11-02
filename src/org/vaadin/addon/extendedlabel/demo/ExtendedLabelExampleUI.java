package org.vaadin.addon.extendedlabel.demo;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

public class ExtendedLabelExampleUI extends UI {
	
	@Override
	protected void init(VaadinRequest request) {
		addComponent(new Label("hello"));
		/*
		Navigator navigator = new Navigator(this, getContent());
		
		navigator.addView(MarkdownView.getViewName(), MarkdownView.class);
		navigator.addView(CreoleView.getViewName(), CreoleView.class);
		navigator.addView(TextileView.getViewName(), TextileView.class);
		
		navigator.navigate();
		*/
		
	}

}
