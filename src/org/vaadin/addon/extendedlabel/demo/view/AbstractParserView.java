package org.vaadin.addon.extendedlabel.demo.view;

import org.vaadin.addon.extendedlabel.ExtendedLabel;
import org.vaadin.addon.extendedlabel.demo.ExampleSyntax;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.AbstractSelect.Filtering;

public abstract class AbstractParserView extends CustomComponent implements View {

	private Panel processed;
	
	public AbstractParserView() {
		VerticalLayout vl = new VerticalLayout();
		vl.setSpacing(true);
		vl.setMargin(true);
		setCompositionRoot(vl);
		
		ComboBox combo = new ComboBox("Choose what syntax to view:");
		combo.addItem("Markdown");
		combo.addItem("Textile");
		combo.addItem("Creole");
		combo.setFilteringMode(Filtering.FILTERINGMODE_OFF);
		combo.setImmediate(true);
		combo.setValue("Creole");
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
		
		addComponent(combo);
		
		setupContent();
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		
		processed.addComponent(getLabel(getExampleSyntax()));

	}
	
	private void setupContent() {
		
		HorizontalLayout hl = new HorizontalLayout();
		addComponent(hl);
		
		Panel normal = new Panel(getViewName() + " syntax");
		TextArea editor = new TextArea("Syntax editor", getExampleSyntax());
		editor.setRows(30);
		editor.setColumns(20);
		editor.addListener((TextChangeListener) this);
		editor.setImmediate(true);
		normal.addComponent(editor);
		hl.addComponent(normal);
		
		this.processed = new Panel("Processed syntax");
		hl.addComponent(processed);
		
		hl.setComponentAlignment(normal, Alignment.TOP_LEFT);
		hl.setComponentAlignment(processed, Alignment.TOP_LEFT);
	}
	
	protected abstract String getExampleSyntax();
	
	protected abstract ExtendedLabel getLabel(String syntax);
	
	public static String getViewName() {
		return "DEFAULT_NAME";
	}

}
