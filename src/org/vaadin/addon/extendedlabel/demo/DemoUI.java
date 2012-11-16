package org.vaadin.addon.extendedlabel.demo;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.AbstractSelect.Filtering;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class DemoUI extends UI {

	VerticalLayout contentRoot;
	
	@Override
	protected void init(VaadinRequest request) {
		
		contentRoot = new VerticalLayout();
		
		setContent(contentRoot);

		setupSelection();
		setupExamples();
	}

	private void setupExamples() {
		// TODO Auto-generated method stub
		
	}

	private void setupSelection() {
		ComboBox combo = new ComboBox("Choose what syntax to view:");
		combo.addItem("Creole");
		combo.addItem("Markdown");
		combo.addItem("Textile");
		combo.setFilteringMode(Filtering.FILTERINGMODE_OFF);
		combo.setImmediate(true);
		combo.setValue("Creole");
		combo.setNullSelectionAllowed(false);
		
		addComponent(combo);
	}

}
