package com.thunder.sky.GUI;

import java.awt.Font;

/**
 * Stores commonly used fonts
 */

public enum Fonts {
    fpsCounter("Lucida Console", Font.PLAIN, Play.width/110),
    inactive("Verdana", Font.PLAIN, Play.width/60),
    active("Open Sans", Font.BOLD, Play.width/40);

    String fontName;
    int fontStyle;
    int fontSize;

    Fonts(String name, int style, int size) {
        fontName = name;
        fontStyle = style;
        fontSize = size;
    }

    Font getFont() {
        return new Font(fontName, fontStyle, fontSize);
    }
}
