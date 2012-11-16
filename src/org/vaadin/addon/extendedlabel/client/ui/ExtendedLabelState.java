package org.vaadin.addon.extendedlabel.client.ui;

import com.github.rjeschke.txtmark.Processor;
import com.vaadin.shared.ui.label.LabelState;

public class ExtendedLabelState extends LabelState {
	public ExtendedContentMode extendedContentMode = ExtendedContentMode.TEXT;
	
	public String getMarkdown() {
		return "MARKDOWN: " + Processor.process(text);
	}
	
	public String getCreole() {
		return "CREOLE: " + text;
	}
	
	public String getTextile() {
		return "TEXTILE: " + text;
	}
}
