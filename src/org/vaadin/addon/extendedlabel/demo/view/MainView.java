package org.vaadin.addon.extendedlabel.demo.view;

import org.vaadin.addon.extendedlabel.ExtendedLabel;

public class MainView extends AbstractParserView {

	@Override
	protected String getExampleSyntax() {
		return "";
	}

	@Override
	protected ExtendedLabel getLabel(String syntax) {
		return new ExtendedLabel("");
	}

	public static String getViewName() {
		return "";
	}
}
