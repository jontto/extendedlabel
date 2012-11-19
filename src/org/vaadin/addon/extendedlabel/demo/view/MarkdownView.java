package org.vaadin.addon.extendedlabel.demo.view;

import org.vaadin.addon.extendedlabel.SSExtendedLabel;
import org.vaadin.addon.extendedlabel.client.ui.ExtendedContentMode;
import org.vaadin.addon.extendedlabel.demo.ExampleSyntax;

public class MarkdownView extends AbstractParserView {

	public MarkdownView() {
		super(getViewName());
	}
	
	@Override
	protected String getExampleSyntax() {
		return ExampleSyntax.getMarkdownSample();
	}

	@Override
	protected SSExtendedLabel getLabel(String syntax) {
		return new SSExtendedLabel(syntax, ExtendedContentMode.MARKDOWN);
	}

	public static String getViewName() {
		return "Markdown";
	}

}
