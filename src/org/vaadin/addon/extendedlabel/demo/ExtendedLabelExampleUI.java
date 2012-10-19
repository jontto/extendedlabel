package org.vaadin.addon.extendedlabel.demo;

import org.vaadin.addon.extendedlabel.demo.view.CreoleView;
import org.vaadin.addon.extendedlabel.demo.view.MarkdownView;
import org.vaadin.addon.extendedlabel.demo.view.TextileView;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

public class ExtendedLabelExampleUI extends UI {
	
	@Override
	protected void init(VaadinRequest request) {
		
		Navigator navigator = new Navigator(this, getContent());
		
		navigator.addView(MarkdownView.getViewName(), MarkdownView.class);
		navigator.addView(CreoleView.getViewName(), CreoleView.class);
		navigator.addView(TextileView.getViewName(), TextileView.class);
		
		navigator.navigate();
		
	}

}
