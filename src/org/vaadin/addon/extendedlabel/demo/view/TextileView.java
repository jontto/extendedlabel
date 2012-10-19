package org.vaadin.addon.extendedlabel.demo.view;

import org.vaadin.addon.extendedlabel.ExtendedLabel;
import org.vaadin.addon.extendedlabel.demo.ExampleSyntax;

public class TextileView extends AbstractParserView {

	@Override
	protected String getExampleSyntax() {
		return ExampleSyntax.getTextileSample();
	}

	@Override
	protected ExtendedLabel getLabel(String syntax) {
		return new ExtendedLabel(syntax, ExtendedLabel.CONTENT_TEXTILE);
	}

	public static String getViewName() {
		return "Textile";
	}
	
	

}
