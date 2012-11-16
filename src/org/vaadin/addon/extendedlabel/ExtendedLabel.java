package org.vaadin.addon.extendedlabel;


import org.vaadin.addon.extendedlabel.client.ui.ExtendedContentMode;
import org.vaadin.addon.extendedlabel.client.ui.ExtendedLabelState;

import com.vaadin.ui.Label;

/**
 * Server side component for the VMarkdownLabel widget.
 */

public class ExtendedLabel extends Label {

	private String originalMarkup = "";
	
	int isExtendedLabel = 0;
	
	public ExtendedLabel() {
		this("");
	}
	
	public ExtendedLabel(String string) {
		super(string);
	}
	
	public ExtendedLabel(String string, ExtendedContentMode contentMode) {
		super(string);
		setContentMode(contentMode);
	}
	
	public void setContentMode(ExtendedContentMode contentMode) {
	  if (contentMode == null) {
          throw new IllegalArgumentException("Content mode can not be null");
      }

      getState().extendedContentMode = contentMode;
	}
	
	@Override
	public ExtendedLabelState getState() {
		return (ExtendedLabelState) super.getState();
	}
	
}
