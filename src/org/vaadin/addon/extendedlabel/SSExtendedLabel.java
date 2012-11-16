package org.vaadin.addon.extendedlabel;

import net.sf.textile4j.Textile;

import org.vaadin.addon.extendedlabel.client.ui.ExtendedContentMode;

import ys.wikiparser.WikiParser;

import com.github.rjeschke.txtmark.Processor;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;

public class SSExtendedLabel extends Label {

	private String content;
	private ExtendedContentMode extendedContentMode;
	
	public SSExtendedLabel(String text) {
		this(text, ExtendedContentMode.TEXT);
	}
	
	public SSExtendedLabel(String text, ExtendedContentMode extendedContentMode) {
		setValue(text);
		setContentMode(extendedContentMode);
	}
	
	public void setValue(String value) {
		this.content = value;
		super.setValue(getValueForLabel());
	}

	public void setContentMode(ExtendedContentMode contentMode) {
		this.extendedContentMode = contentMode;
		super.setContentMode(getContentModeForLabel());
		super.setValue(getValueForLabel());
	}
	
	private String getValueForLabel() {
		if(this.extendedContentMode == null) {
			return "";
		}
		switch(this.extendedContentMode) {
		case CREOLE:
			return WikiParser.renderXHTML(this.content);
		case MARKDOWN:
			return Processor.process(this.content);
		case TEXTILE:
			return new Textile().process(this.content);
		default:
			return this.content;
		}
	}
	
	private ContentMode getContentModeForLabel() {
		switch(this.extendedContentMode) {
		case CREOLE:
		case MARKDOWN:
		case TEXTILE:
		case HTML:
			return ContentMode.HTML;
		case PREFORMATTED:
			return ContentMode.PREFORMATTED;
		case RAW:
			return ContentMode.RAW;
		case XML:
			return ContentMode.XML;
		case TEXT:
		default:
			return ContentMode.TEXT;
		}
	}

	private boolean isExtendedContent() {
		if(extendedContentMode == ExtendedContentMode.CREOLE
				|| extendedContentMode == ExtendedContentMode.MARKDOWN
				|| extendedContentMode == ExtendedContentMode.TEXTILE) {
			return true;
		} else {
			return false;
		}
	}
}
