package org.vaadin.addon.extendedlabel.demo.view;

import org.vaadin.addon.extendedlabel.ExtendedLabel;
import org.vaadin.addon.extendedlabel.client.ui.ExtendedContentMode;
import org.vaadin.addon.extendedlabel.demo.ExampleSyntax;

public class TextileView extends AbstractParserView {

	@Override
	protected String getExampleSyntax() {
		return ExampleSyntax.getTextileSample();
	}

	@Override
	protected ExtendedLabel getLabel(String syntax) {
		return new ExtendedLabel(syntax, ExtendedContentMode.TEXTILE);
	}

	public static String getViewName() {
		return "Textile";
	}
	
	

}