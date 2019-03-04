package com.hyoseog.effectivejava.chapter6.item36;

import java.util.EnumSet;

public class TextMain {

    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Text.Style.BOLD, Text.Style.ITALIC));
    }

}
