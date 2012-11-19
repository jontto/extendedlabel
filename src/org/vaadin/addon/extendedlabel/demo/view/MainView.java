package org.vaadin.addon.extendedlabel.demo.view;

import org.vaadin.addon.extendedlabel.SSExtendedLabel;

public class MainView extends AbstractParserView {

	public MainView() {
		super(getViewName());
	}
	
	@Override
	protected String getExampleSyntax() {
		return "";
	}

	@Override
	protected SSExtendedLabel getLabel(String syntax) {
		return new SSExtendedLabel("");
	}

	public static String getViewName() {
		return "";
	}
}
