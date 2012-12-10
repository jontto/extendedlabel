package org.vaadin.addon.extendedlabel.demo.view;

import org.vaadin.addon.extendedlabel.SSExtendedLabel;
import org.vaadin.addon.extendedlabel.client.ui.ExtendedContentMode;
import org.vaadin.addon.extendedlabel.demo.ExampleSyntax;

import com.vaadin.navigator.Navigator;

public class CreoleView extends AbstractParserView {

	public CreoleView(Navigator navigator) {
		super(getViewName(), navigator);
	}
	
	@Override
	protected String getExampleSyntax() {
		return ExampleSyntax.getCreoleSample();
	}

	@Override
	protected SSExtendedLabel getLabel() {
		return new SSExtendedLabel(getExampleSyntax(), ExtendedContentMode.CREOLE);
	}

	public static String getViewName() {
		return "Creole";
	}

}
