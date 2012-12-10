package org.vaadin.addon.extendedlabel.demo.view;

import org.vaadin.addon.extendedlabel.SSExtendedLabel;
import org.vaadin.addon.extendedlabel.client.ui.ExtendedContentMode;
import org.vaadin.addon.extendedlabel.demo.ExampleSyntax;

import com.vaadin.navigator.Navigator;

public class TextileView extends AbstractParserView {

	public TextileView(Navigator navigator) {
		super(getViewName(), navigator);
	}
	
	@Override
	protected String getExampleSyntax() {
		return ExampleSyntax.getTextileSample();
	}

	@Override
	protected SSExtendedLabel getLabel() {
		return new SSExtendedLabel(getExampleSyntax(), ExtendedContentMode.TEXTILE);
	}

	public static String getViewName() {
		return "Textile";
	}
	
	

}
