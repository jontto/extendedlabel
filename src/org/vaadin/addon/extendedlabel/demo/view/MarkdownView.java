package org.vaadin.addon.extendedlabel.demo.view;

import org.vaadin.addon.extendedlabel.SSExtendedLabel;
import org.vaadin.addon.extendedlabel.client.ui.ExtendedContentMode;
import org.vaadin.addon.extendedlabel.demo.ExampleSyntax;

import com.vaadin.navigator.Navigator;

public class MarkdownView extends AbstractParserView {

	public MarkdownView(Navigator navigator) {
		super(getViewName(), navigator);
	}
	
	@Override
	protected String getExampleSyntax() {
		return ExampleSyntax.getMarkdownSample();
	}

	@Override
	protected SSExtendedLabel getLabel() {
		return new SSExtendedLabel(getExampleSyntax(), ExtendedContentMode.MARKDOWN);
	}

	public static String getViewName() {
		return "Markdown";
	}

}
