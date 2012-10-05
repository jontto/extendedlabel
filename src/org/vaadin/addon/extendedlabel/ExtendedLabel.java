package org.vaadin.addon.extendedlabel;


import com.github.rjeschke.txtmark.Processor;
import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;
import com.vaadin.ui.ClientWidget;
import com.vaadin.ui.Label;

import net.sf.textile4j.Textile;

import org.apache.commons.lang.NotImplementedException;
import org.vaadin.addon.extendedlabel.client.ui.VExtendedLabel;

import ys.wikiparser.WikiParser;

/**
 * Server side component for the VMarkdownLabel widget.
 */

@ClientWidget(VExtendedLabel.class)
public class ExtendedLabel extends Label {

	/** Array of content mode names that are rendered in UIDL as mode attribute. */
    private static final String[] CONTENT_MODE_NAME = { "text", "pre", "uidl",
            "xhtml", "xml", "raw", "markdown", "textile", "creole" };
	
	public static final int CONTENT_MARKDOWN = 6;
	public static final int CONTENT_TEXTILE = 7;
	public static final int CONTENT_CREOLE = 8;
	
	private String originalMarkup = "";
	
	int isExtendedLabel = 0;
	
	public ExtendedLabel() {
		this("");
	}
	
	public ExtendedLabel(String string) {
		this(string, CONTENT_DEFAULT);
	}
	
	public ExtendedLabel(String markup, int contentMode) {
		super(markup, contentMode);
		if(contentMode >= CONTENT_MARKDOWN) {
			isExtendedLabel = contentMode;
			originalMarkup = markup;
		}
	}
	
	@Override
	public void paintContent(PaintTarget target) throws PaintException {
        if (getContentMode() != CONTENT_TEXT) {
            target.addAttribute("mode", CONTENT_MODE_NAME[getContentMode()]);
        }
        if (getContentMode() == CONTENT_TEXT) {
            target.addText(toString());
        } else if (getContentMode() == CONTENT_UIDL) {
            target.addUIDL(toString());
        } else if (getContentMode() == CONTENT_XHTML || isExtendedContent()) {
            target.startTag("data");
            target.addXMLSection("div", processExtendedSyntax(toString()),
                    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd");
            target.endTag("data");
        } else if (getContentMode() == CONTENT_PREFORMATTED) {
            target.startTag("pre");
            target.addText(toString());
            target.endTag("pre");
        } else if (getContentMode() == CONTENT_XML) {
            target.addXMLSection("data", toString(), null);
        } else if (getContentMode() == CONTENT_RAW) {
            target.startTag("data");
            target.addAttribute("escape", false);
            target.addText(toString());
            target.endTag("data");
        }
	}
	
	private boolean isExtendedContent() {
		if(getContentMode() >= CONTENT_MARKDOWN) {
			return true;
		} else {
			return false;
		}
	}
	
	private String processExtendedSyntax(String markup) {
		if(!isExtendedContent()) {
			return markup;
		}
		String result = null;
		if(getContentMode() == CONTENT_MARKDOWN) {
			result = Processor.process(markup);
		} else if(getContentMode() == CONTENT_TEXTILE) {
			Textile textile = new Textile();
			result = textile.process(markup);
		} else if(getContentMode() == CONTENT_CREOLE) {
			result = WikiParser.renderXHTML(markup);
		}
		return result;
	}
	
	@Override
	public void setContentMode(int contentMode) {
        if(contentMode >= CONTENT_MARKDOWN) {
        	this.isExtendedLabel = contentMode;
        } else {
        	this.isExtendedLabel = 0;
        }
        super.setContentMode(contentMode);
    }
	
	@Override
	public int getContentMode() {
		if(isExtendedLabel >= CONTENT_MARKDOWN) {
			return isExtendedLabel;
		} else {
			return super.getContentMode();
		}
	}

}
