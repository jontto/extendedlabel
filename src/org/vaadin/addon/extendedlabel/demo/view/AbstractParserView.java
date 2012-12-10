package org.vaadin.addon.extendedlabel.demo.view;

import org.vaadin.addon.extendedlabel.SSExtendedLabel;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

public abstract class AbstractParserView extends CustomComponent implements View {

	private Panel processed;
	private VerticalLayout root;
	private VerticalLayout editorLayout;
	private static VerticalLayout processedLayout;
	private static ComboBox combo;
	private static Navigator navigator;
	
	public AbstractParserView(String viewName, final Navigator navigator) {
		AbstractParserView.navigator = navigator;
		root = new VerticalLayout();
		root.setSpacing(true);
		root.setMargin(true);
		setCompositionRoot(root);

		combo = new ComboBox("Choose what syntax to view:");
		combo.addItem("Markdown");
		combo.addItem("Textile");
		combo.addItem("Creole");
		combo.setImmediate(true);

		combo.setValue(viewName);
		combo.setNullSelectionAllowed(false);

		combo.addValueChangeListener(new ValueChangeListener() {
			
			@Override
			public void valueChange(ValueChangeEvent event) {
				navigator.navigateTo((String) combo.getValue());
			}
		});
		root.addComponent(combo);
		
		this.viewName = viewName; 
		setupContent();
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		processedLayout.removeAllComponents();
		processedLayout.addComponent(getLabel());

	}
	
	private void setupContent() {
		
		HorizontalLayout hl = new HorizontalLayout();
		root.addComponent(hl);
		
		Panel normal = new Panel(getViewName() + " syntax");
		editorLayout = new VerticalLayout();
		normal.setContent(editorLayout);
		TextArea editor = new TextArea("Syntax editor", getExampleSyntax());
		editor.setRows(30);
		editor.setColumns(20);
		editor.setImmediate(true);
		editorLayout.addComponent(editor);
		hl.addComponent(normal);
		
		this.processed = new Panel("Processed syntax");
		processedLayout = new VerticalLayout();
		processed.setContent(processedLayout);
		hl.addComponent(processed);
		
		hl.setComponentAlignment(normal, Alignment.TOP_LEFT);
		hl.setComponentAlignment(processed, Alignment.TOP_LEFT);
	}
	
	protected abstract String getExampleSyntax();
	
	protected abstract SSExtendedLabel getLabel();

	protected String viewName;
	
	private String getViewName() {
		return this.viewName;
	}
}
