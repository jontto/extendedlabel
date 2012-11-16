package org.vaadin.addon.extendedlabel.client.ui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.PreElement;
import com.vaadin.client.Util;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.label.LabelConnector;
import com.vaadin.shared.ui.Connect;

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
        switch (getState().extendedContentMode) {
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
        	getWidget().setHTML(getState().getCreole());
        	break;
        case MARKDOWN:
        	sinkOnloads = true;
        	getWidget().setHTML(getState().getMarkdown());
        	break;
        case TEXTILE:
        	sinkOnloads = true;
        	getWidget().setHTML(getState().getTextile());
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
