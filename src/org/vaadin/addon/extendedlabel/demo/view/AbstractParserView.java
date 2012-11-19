package org.vaadin.addon.extendedlabel.demo.view;

import org.vaadin.addon.extendedlabel.SSExtendedLabel;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbstractSelect.Filtering;
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
	private VerticalLayout editorLayout, processedLayout;
	
	public AbstractParserView(String viewName) {
		root = new VerticalLayout();
		root.setSpacing(true);
		root.setMargin(true);
		setCompositionRoot(root);
		
		ComboBox combo = new ComboBox("Choose what syntax to view:");
		combo.addItem("Markdown");
		combo.addItem("Textile");
		combo.addItem("Creole");
		combo.setFilteringMode(Filtering.FILTERINGMODE_OFF);
		combo.setImmediate(true);
		combo.setValue("Markdown");
		combo.setNullSelectionAllowed(false);
//		combo.addListener(new Property.ValueChangeListener() {
//			@Override
//			public void valueChange(ValueChangeEvent event) {
//				hl.removeAllComponents();
//				if(event.getProperty().getValue().equals("Markdown")) {
//					setMarkdownContent();
//				} else if(event.getProperty().getValue().equals("Textile")) {
//					setTextileContent();
//				} else if(event.getProperty().getValue().equals("Creole")) {
//					setCreoleContent();
//				}
//			}
//		});
		
		root.addComponent(combo);
		
		this.viewName = viewName; 
		setupContent();
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		
		processedLayout.addComponent(getLabel(getExampleSyntax()));

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
	
	protected abstract SSExtendedLabel getLabel(String syntax);

	protected String viewName;
	
	private String getViewName() {
		return this.viewName;
	}
}
