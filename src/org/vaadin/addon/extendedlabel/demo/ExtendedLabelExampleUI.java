package org.vaadin.addon.extendedlabel.demo;

import org.vaadin.addon.extendedlabel.ExtendedContentMode;
import org.vaadin.addon.extendedlabel.ExtendedLabel;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ExtendedLabelExampleUI extends UI {
	
	private VerticalLayout content;
	private ComboBox combo;
	private Panel processed;
	private Panel syntaxPanel;
	private TextArea editor;
	private VerticalLayout processedLayout;

	@Override
	protected void init(VaadinRequest request) {
		
		content = new VerticalLayout();
		content.setSpacing(true);
		content.setMargin(true);
		setContent(content);
		
		setupSelection();
		setupContent();
		combo.setValue("Markdown");
	}

	private void setupSelection() {
		combo = new ComboBox("Choose what syntax to view:");
		combo.addItem("Markdown");
		combo.addItem("Textile");
		combo.addItem("Creole");
		combo.setImmediate(true);

		combo.setNullSelectionAllowed(false);

		combo.addValueChangeListener(new ValueChangeListener() {
			
			@Override
			public void valueChange(ValueChangeEvent event) {
				updateContent();
			}
		});
		content.addComponent(combo);
	}

	private void setupContent() {
		HorizontalLayout hl = new HorizontalLayout();
		hl.setSpacing(true);
		content.addComponent(hl);
		
		syntaxPanel = new Panel("Syntax editor");
		VerticalLayout editorLayout = new VerticalLayout();
		syntaxPanel.setContent(editorLayout);
		editor = new TextArea();
		editor.setRows(30);
		editor.setColumns(20);
		editor.setImmediate(true);
		editorLayout.addComponent(editor);
		hl.addComponent(syntaxPanel);
		
		processed = new Panel("Processed syntax");
		processedLayout = new VerticalLayout();
		processedLayout.setMargin(true);
		processed.setContent(processedLayout);
		hl.addComponent(processed);
		
		hl.setComponentAlignment(syntaxPanel, Alignment.TOP_LEFT);
		hl.setComponentAlignment(processed, Alignment.TOP_LEFT);
		
	}
	
	private void updateContent() {
		editor.setValue(getExampleSyntax());
		processedLayout.removeAllComponents();
		processedLayout.addComponent(getExampleLabel());
	}

	private ExtendedLabel getExampleLabel() {
		ExtendedLabel label = new ExtendedLabel(getExampleSyntax());
		String syntax = ((String) combo.getValue());
		if(syntax.equalsIgnoreCase("Creole")) {
			label.setContentMode(ExtendedContentMode.CREOLE);
		} else if(syntax.equalsIgnoreCase("Textile")) {
			label.setContentMode(ExtendedContentMode.TEXTILE);
		} else if(syntax.equalsIgnoreCase("Markdown")) {
			label.setContentMode(ExtendedContentMode.MARKDOWN);
		}
		return label;
	}

	private String getExampleSyntax() {
		String syntax = ((String) combo.getValue());
			
		if(syntax.equalsIgnoreCase("Creole")) {
			return ExampleSyntax.getCreoleSample();
		} else if(syntax.equalsIgnoreCase("Textile")) {
			return ExampleSyntax.getTextileSample();
		} else if(syntax.equalsIgnoreCase("Markdown")) {
			return ExampleSyntax.getMarkdownSample();
		} else {
			return "";
		}
	}

}
