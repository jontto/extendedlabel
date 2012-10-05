package org.vaadin.addon.extendedlabel.example.view;

import org.vaadin.addon.extendedlabel.ExtendedLabel;
import org.vaadin.addon.extendedlabel.example.ExampleSyntax;

public class CreoleView extends AbstractParserView {

	@Override
	protected String getExampleSyntax() {
		return ExampleSyntax.getCreoleSample();
	}

	@Override
	protected ExtendedLabel getLabel(String syntax) {
		return new ExtendedLabel(syntax, ExtendedLabel.CONTENT_CREOLE);
	}

	public static String getViewName() {
		return "Creole";
	}

}
