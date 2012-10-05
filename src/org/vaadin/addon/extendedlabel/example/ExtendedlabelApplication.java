package org.vaadin.addon.extendedlabel.example;

import org.vaadin.addon.extendedlabel.ExtendedLabel;

import com.vaadin.Application;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.AbstractSelect.Filtering;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class ExtendedlabelApplication extends Application implements TextChangeListener, 
	Property.ValueChangeListener {
	
	private ExtendedLabel extendedlabel;
	private HorizontalLayout hl;
	
	@Override
	public void init() {
		VerticalLayout rootLayout = new VerticalLayout();
		rootLayout.setSpacing(true);
		rootLayout.setMargin(true);
		Window mainWindow = new Window("Markdownforvaadin Application");
		mainWindow.setContent(rootLayout);
		setMainWindow(mainWindow);
		
		ComboBox combo = new ComboBox("Choose what syntax to view:");
		combo.addItem("Markdown");
		combo.addItem("Textile");
		combo.addItem("Creole");
		combo.setFilteringMode(Filtering.FILTERINGMODE_OFF);
		combo.setImmediate(true);
		combo.setValue("Creole");
		combo.setNullSelectionAllowed(false);
		combo.addListener(new Property.ValueChangeListener() {
			@Override
			public void valueChange(ValueChangeEvent event) {
				hl.removeAllComponents();
				if(event.getProperty().getValue().equals("Markdown")) {
					setMarkdownContent();
				} else if(event.getProperty().getValue().equals("Textile")) {
					setTextileContent();
				} else if(event.getProperty().getValue().equals("Creole")) {
					setCreoleContent();
				}
			}
		});
		mainWindow.addComponent(combo);
		
		hl = new HorizontalLayout();
		this.setCreoleContent();
		
		mainWindow.addComponent(hl);
	}
	
	private void setMarkdownContent() {
		String syntax = ExampleSyntax.getMarkdownSample();
		
		Panel normal = new Panel("Markdown syntax");
		TextArea editor = new TextArea("Syntax editor", syntax);
		editor.setRows(30);
		editor.setColumns(20);
		editor.addListener((TextChangeListener) this);
		editor.setImmediate(true);
		normal.addComponent(editor);
		hl.addComponent(normal);
		
		Panel processed = new Panel("Processed syntax");
		extendedlabel = new ExtendedLabel();
		extendedlabel.setValue(syntax);
		extendedlabel.setContentMode(ExtendedLabel.CONTENT_MARKDOWN);
		processed.addComponent(extendedlabel);
		hl.addComponent(processed);
		
		hl.setComponentAlignment(normal, Alignment.TOP_LEFT);
		hl.setComponentAlignment(processed, Alignment.TOP_LEFT);
	}
	
	private void setTextileContent() {
		String syntax = ExampleSyntax.getTextileSample();
		
		Panel normal = new Panel("Textile syntax");
		TextArea editor = new TextArea("Syntax editor", syntax);
		editor.setRows(30);
		editor.setColumns(20);
		editor.addListener((TextChangeListener) this);
		editor.setImmediate(true);
		normal.addComponent(editor);
		hl.addComponent(normal);
		
		Panel processed = new Panel("Processed syntax");
		extendedlabel = new ExtendedLabel();
		extendedlabel.setValue(syntax);
		extendedlabel.setContentMode(ExtendedLabel.CONTENT_TEXTILE);
		processed.addComponent(extendedlabel);
		hl.addComponent(processed);
		
		hl.setComponentAlignment(normal, Alignment.TOP_LEFT);
		hl.setComponentAlignment(processed, Alignment.TOP_LEFT);
	}
	
	private void setCreoleContent() {
		String syntax = ExampleSyntax.getCreoleSample();
		
		Panel normal = new Panel("Creole syntax");
		TextArea editor = new TextArea("Syntax editor", syntax);
		editor.setRows(30);
		editor.setColumns(20);
		editor.addListener((TextChangeListener) this);
		editor.setImmediate(true);
		normal.addComponent(editor);
		hl.addComponent(normal);
		
		Panel processed = new Panel("Processed syntax");
		extendedlabel = new ExtendedLabel();
		extendedlabel.setValue(syntax);
		extendedlabel.setContentMode(ExtendedLabel.CONTENT_CREOLE);
		processed.addComponent(extendedlabel);
		hl.addComponent(processed);
		
		hl.setComponentAlignment(normal, Alignment.TOP_LEFT);
		hl.setComponentAlignment(processed, Alignment.TOP_LEFT);
	}

	public void textChange(TextChangeEvent event) {
		String editorText = event.getText();
		extendedlabel.setValue(editorText);
	}

	@Override
	public void valueChange(ValueChangeEvent event) {
		
	}

}
