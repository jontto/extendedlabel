package org.vaadin.addon.extendedlabel.demo.view;

import org.vaadin.addon.extendedlabel.ExtendedLabel;
import org.vaadin.addon.extendedlabel.demo.ExampleSyntax;

public class MarkdownView extends AbstractParserView {

	@Override
	protected String getExampleSyntax() {
		return ExampleSyntax.getMarkdownSample();
	}

	@Override
	protected ExtendedLabel getLabel(String syntax) {
		return new ExtendedLabel(syntax, ExtendedLabel.CONTENT_MARKDOWN);
	}

	public static String getViewName() {
		return "Markdown";
	}

}
