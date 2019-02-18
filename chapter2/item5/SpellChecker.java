package com.hyoseog.effectivejava.chapter2.item5;

import java.util.Objects;
// 사전이 언어별로 따로 있고, 특수 어휘용 사전을 별도로 두기도하고, 테스트용 사전도 있다.
// 사전 하나로 이 모든 쓰임에 대응할 수 있기를 바라지 말자..
// SpellChecker 가 여러 사전을 사용할 수 있도록
public class SpellChecker {
    private final Lexicon dictionary;

    // 인스턴스를 생성할 때 생성자에 필요한 자원(dictionary)을 넘겨주는 방식
    // Lexicon dictionary 매개 변수
    // 의존 객체 주입의 한 형태
    // Depedency Injection
    // Inverse of Control
    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }
}
