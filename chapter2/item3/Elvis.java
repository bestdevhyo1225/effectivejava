package com.hyoseog.effectivejava.chapter2.item3;

public class Elvis {
    // 1.
    // private 생성자는 Elvis.INSTANCE 를 초기화 할 때, 딱 한 번만 호출 된다.
    // public static final 필드 방식의 장점
    // -> 해당 클래스가 싱글턴임을 API 에 명백히 드러난다는 것
    // -> 간결함
    private static final Elvis INSTANCE = new Elvis();
    private Elvis() {}

    // 2.
    // 정적 팩터리 메서드를 public static 멤버로 제공
    // private 로 변경
    // private static final Elvis INSTANCE = new Elvis();
    // 정적 팩터리 방식의 장점
    // -> API 를 바꾸지 않고도 싱글턴이 아니게 변경할 수 있다는 점
    // -> 원한다면 정적 팩터리를 제네릭 싱글턴 팩터리로 만들 수 있다는 점
    // -> 정적 팩터리의 메서드 참조를 공급자(supplier)로 사용할 수 있다는 점
    //      ex) Elvis::getInstance 를 Supplier<Elvis> 로 사용하는 식
    public static Elvis getInstance() { return INSTANCE; }

    public void leaveTheBuilding() {}

    // 싱글턴임을 보장해주는 readResolve 메서드
    private Object readResolve() {
        // '진짜' Elvis 를 반환하고, 가짜 Elvis 는 가비지 컬렉터에 맡긴다.
        return INSTANCE;
    }
}
