package org.vaadin.addon.extendedlabel.client.ui;

import org.vaadin.addon.extendedlabel.ExtendedLabel;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.PreElement;
import com.vaadin.client.Util;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.label.LabelConnector;
import com.vaadin.client.ui.label.VLabel;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.label.LabelState;

@Connect(org.vaadin.addon.extendedlabel.ExtendedLabel.class)
public class ExtendedLabelConnector extends LabelConnector {

	@Override
    public ExtendedLabelState getState() {
        return (ExtendedLabelState) super.getState();
    }

	
	@Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        boolean sinkOnloads = false;
        switch (getState().contentMode) {
        case PREFORMATTED:
            PreElement preElement = Document.get().createPreElement();
            preElement.setInnerText(getState().text);
            // clear existing content
            getWidget().setHTML("");
            // add preformatted text to dom
            getWidget().getElement().appendChild(preElement);
            break;

        case TEXT:
            getWidget().setText(getState().text);
            break;

        case HTML:
        case RAW:
            sinkOnloads = true;
        case XML:
            getWidget().setHTML(getState().text);
            break;
            
        case CREOLE:
        	sinkOnloads = true;
        	getWidget().setHTML("CREOLE: " + getState().text);
        	break;
        case MARKDOWN:
        	sinkOnloads = true;
        	getWidget().setHTML("MARKDOWN: " + getState().text);
        	break;
        case TEXTILE:
        	sinkOnloads = true;
        	getWidget().setHTML("TEXTTILE: " + getState().text);
        	break;
        default:
            getWidget().setText("");
            break;

        }
        if (sinkOnloads) {
            Util.sinkOnloadForImages(getWidget().getElement());
        }
    }
	

    @Override
    public VExtendedLabel getWidget() {
        return (VExtendedLabel) super.getWidget();
    }
}
