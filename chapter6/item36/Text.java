package com.hyoseog.effectivejava.chapter6.item36;

import java.util.Set;

public class Text {
    // 구닥다리 기법....
    /*
    public static final int STYLE_BOLD          = 1 << 0;   // 1
    public static final int STYLE_ITALIC        = 1 << 1;   // 2
    public static final int STYLE_UNDERLINE     = 1 << 2;   // 4
    public static final int STYLE_STRIKETHROUGH = 1 << 3;   // 8

    // 매개변수 styles 는 0개 이상의 STYLE_ 상수를 비트별 OR 한 값이다.
    // ex) text.applyStyles(STYLE_BOLD | STYLE_ITALIC);
    public void applyStyles(int styles) {}
    */

    // EnumSet 클래스를 사용하자!!
    public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }

    // 어떤 Set 을 넘겨도 되나, EnumSet 이 가장 좋다.
    public void applyStyles(Set<Style> styles) {}

}
