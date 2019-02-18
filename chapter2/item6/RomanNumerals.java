package com.hyoseog.effectivejava.chapter2.item6;

import java.util.regex.Pattern;

// Item 6. 불필요한 객체 생성을 피하라
// 똑같은 기능의 객체를 매번 생성하기보다는 객체 하나를 재사용하자
// 특히 불변 객체는 언제든지 재사용할 수 있다.
// < 절대로 작성하면 안되는 코드 >
// String s = new String("aaa"); -> 실행될 때마다 String 인스턴스를 사용함
// < 개선된 코드 >
// String s = "aaa"; -> 매번 만드는 대신 하나의 인스턴스를 사용한다.
public class RomanNumerals {
    // < 1. 문제가 되는 코드 >
    // 이 방식의 문제는 String.matches 메서드를 사용한다는데 있다.
    // 간단한 방법이지만, 성능이 중요한 상황에서 반복해 사용하기엔 적합하지 않다.
    // 메서드가 내부에서 만드는 정규표현식용 Pattern 인스턴스는 한 번 쓰고 버려져서
    // 곧바로 가비지 컬렉션 대상이 된다.
    // 정규표현식에 해당하는 유한 상태 머신을 만들기 때문에 인스턴스 생성 비용이 높다.
    /*static boolean isRomanNumeral(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }*/

    // < 2. 개선된 코드 >
    // 필요한 정규표현식을 표현하는 (불변인) Pattern 인스턴스를 클래스 초기화 (정적 초기화)
    // 과정에서 직접 생성해 캐싱해둔다.
    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
                    + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$"
    );

    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}
