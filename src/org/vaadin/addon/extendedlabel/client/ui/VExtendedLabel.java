package org.vaadin.addon.extendedlabel.client.ui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.dom.client.PreElement;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.vaadin.terminal.gwt.client.ApplicationConnection;
import com.vaadin.terminal.gwt.client.Paintable;
import com.vaadin.terminal.gwt.client.UIDL;
import com.vaadin.terminal.gwt.client.ui.VLabel;

public class VExtendedLabel extends VLabel implements Paintable {

	/** Set the CSS class name to allow styling. */
	public static final String CLASSNAME = "v-markdownlabel";

	/** The client side widget identifier */
	protected String paintableId;

	/** Reference to the server connection object. */
	ApplicationConnection client;

	/**
	 * The constructor should first call super() to initialize the component and
	 * then handle any initialization relevant to Vaadin.
	 */
	public VExtendedLabel() {
		super();
	}

	/**
	 * Called whenever an update is received from the server
	 */
	@Override
	public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
		if (client.updateComponent(this, uidl, true)) {
			return;
		}

		this.client = client;

		boolean sinkOnloads = false;

		final String mode = uidl.getStringAttribute("mode");
		if (mode == null || "text".equals(mode)) {
			setText(uidl.getChildString(0));
		} else if ("pre".equals(mode)) {
			PreElement preElement = Document.get().createPreElement();
			preElement.setInnerText(uidl.getChildUIDL(0).getChildString(0));
			// clear existing content
			setHTML("");
			// add preformatted text to dom
			getElement().appendChild(preElement);
		} else if ("uidl".equals(mode)) {
			setHTML(uidl.getChildrenAsXML());
		} else if ("xhtml".equals(mode) 
						|| "markdown".equals(mode)
						|| "textile".equals(mode) 
						|| "creole".equals(mode)) {
			UIDL content = uidl.getChildUIDL(0).getChildUIDL(0);
			if (content.getChildCount() > 0) {
				setHTML(content.getChildString(0));
			} else {
				setHTML("");
			}
			sinkOnloads = true;
		} else if ("xml".equals(mode)) {
			setHTML(uidl.getChildUIDL(0).getChildString(0));
		} else if ("raw".equals(mode)) {
			setHTML(uidl.getChildUIDL(0).getChildString(0));
			sinkOnloads = true;
		} else {
			setText("");
		}
		if (sinkOnloads) {
			sinkOnloadsForContainedImgs();
		}

	}

	private void sinkOnloadsForContainedImgs() {
		NodeList<Element> images = getElement().getElementsByTagName("img");
		for (int i = 0; i < images.getLength(); i++) {
			Element img = images.getItem(i);
			DOM.sinkEvents((com.google.gwt.user.client.Element) img,
					Event.ONLOAD);
		}

	}

}
