package com.hyoseog.effectivejava.chapter2.item3;

// 열거 타입 방식의 싱글턴 - 바람직한 방법
// public 필드 방식과 비슷하지만, 더 간결하고, 추가 노력없이 직렬화 할 수 있다.
// 아주 복잡한 직렬화 상황이나 리플렉션 공격에서도 제 2의 인스턴스가 생기는 일을 완벽히 막아준다.
// 대부분의 상황에서는 원소가 하나뿐인 열거 타입이 싱글턴을 만드는 가장 좋은 방법이다.
// 단, 만들려는 싱글턴이 Enum 외의 클래스를 상속해야 한다면 이 방법은 사용할 수 없다.
// (열거 타입이 다른 인터페이스를 구현하도록 선언할 수는 있다.)
public enum Elvis2 {
    INSTANCE;

    public void leaveTheBuilding() {}
}
