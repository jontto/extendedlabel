package org.vaadin.addon.extendedlabel;


/**
 * @author Jonas Granvik
 * 
 * Basically extends ContentMode enum
 *
 */
public enum ExtendedContentMode {
	/**
     * Content mode, where the label contains only plain text.
     */
    TEXT,

    /**
     * Content mode, where the label contains pre formatted text. In this mode
     * newlines are preserved when rendered on the screen.
     */
    PREFORMATTED,

    /**
     * Content mode, where the label contains HTML.
     */
    HTML,

    /**
     * Content mode, where the label contains well-formed or well-balanced XML.
     * This is handled in the same way as {@link #XHTML}.
     * 
     * @deprecated Use {@link #XHTML} instead
     */
    @Deprecated
    XML,

    /**
     * Legacy content mode, where the label contains RAW output. This is handled
     * in exactly the same way as {@link #XHTML}.
     * 
     * @deprecated Use {@link #XHTML} instead
     */
    @Deprecated
    RAW,
    
    CREOLE,
    TEXTILE,
    MARKDOWN;
	
}
