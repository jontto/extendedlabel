package org.vaadin.addon.extendedlabel.demo;

public class ExampleSyntax {
	
	public static String getMarkdownSample() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Syntax examples\n=============\n\n");
		sb.append("## List\n");
		sb.append("1. Item\n");
		sb.append("2. Stylish text\n");
		sb.append("3. Item with *emphasized* text\n");
		sb.append("4. **This is really _important_**\n");
		sb.append("\n");
		sb.append("[Markdown](http://daringfireball.net/projects/markdown) is cool!\n");
		sb.append("\n***\n");
		sb.append("Normal text\n\n");
		sb.append("\tCode block for special people.\n");
		sb.append("\n");
		sb.append("![Vaadin rocks!](http://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/Vaadin-logo.svg/200px-Vaadin-logo.svg.png \"Vaadin alt text\")\n");
		sb.append("\n");
		sb.append("\n");
		sb.append("\n");
		sb.append("\n");
		sb.append("\n");
		
		return sb.toString();
	}
	
	public static String getTextileSample() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("h1. Syntax examples\n\n");
		sb.append("h2. List\n\n");
		sb.append("1. Item\n");
		sb.append("2. Stylish text\n");
		sb.append("3. Item with _emphasized_ text\n");
		sb.append("4. **This is really _important_ **\n");
		sb.append("\n");
		sb.append("\"Markdown\":http://daringfireball.net/projects/markdown  is cool!\n\n");
		sb.append("<hr />\n\nNormal text\n\n");
		sb.append("@Code block for special people.@\n");
		sb.append("\n\n");
		sb.append("!http://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/Vaadin-logo.svg/200px-Vaadin-logo.svg.png(Vaadin alt text)!\n");
		sb.append("\n");
		sb.append("\n");
		sb.append("\n");
		sb.append("\n");
		sb.append("\n");
		
		return sb.toString();
	}
	
	public static String getCreoleSample() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("=Syntax examples=\n\n");
		sb.append("==List\n\n");
		sb.append("# Item\n");
		sb.append("# Stylish text\n");
		sb.append("# Item with //emphasized// text\n");
		sb.append("# **This is really _important_ **\n");
		sb.append("\n");
		sb.append("[[http://daringfireball.net/projects/markdown|Markdown]] is cool!\n\n");
		sb.append("----\n\nNormal text\n\n");
		sb.append("{{http://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/Vaadin-logo.svg/200px-Vaadin-logo.svg.png|Vaadin alt text}}\n");
		sb.append("\n");
		sb.append("\n");
		sb.append("\n");
		sb.append("\n");
		sb.append("\n");
		
		return sb.toString();
	}
}
