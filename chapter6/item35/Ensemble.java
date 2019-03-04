package com.hyoseog.effectivejava.chapter6.item35;

// 복 4중주 (double quartet) 도 마찬가지로 8 명이지만,
// 8중주 (octet) 때문에 추가할 수가 없다.
// 12명이 연주하는 3중 4중주 (triple quartet) 를 추가하려고 할 때,
// 11명으로 구성된 연주를 일컫는 이름은 없다..
// 그래서 3중 4중주를 추가하려면 쓰이지 않는 더미(dummy) 상수를 같이 추가해야 된다.
// 코드가 깔끔하지 못하고.. 쓰이지 않는 값이 많아질수록 실용성이 떨어진다.
/*public enum Ensemble {

    SOLO, DUET, TRIO, QUARTET, QUNTET,
    SEXTET, SEPTET, OCTET, NONET, DECTET;

    public int numberOfMusiccians() {
        return ordinal() + 1;
    }

}*/

// 해결책) 열거 타입 상수에 연결된 값은 ordinal 메서드로 얻지 말고,
// 인스턴트 필드에 저장하자.
public enum Ensemble {

    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),
    SEXTET(6), SEPTET(7), OCTET(8), DOUBLE_QUARTET(8),
    NONET(9), DECTET(10), TRIPLE_QUARTET(12);

    private final int numberOfMusicians;

    Ensemble(int numberOfMusicians) {
        this.numberOfMusicians = numberOfMusicians;
    }

    public int getNumberOfMusicians() {
        return this.numberOfMusicians;
    }

}

