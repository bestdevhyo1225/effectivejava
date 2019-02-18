package com.hyoseog.effectivejava.chapter2.item2;

import java.util.EnumSet;
import java.util.Objects;

public abstract class Pizza {
    public enum Topping {
        HAM,
        MUSHROOM,
        ONION,
        PEPPER,
        SAUSAGE
    }

    final EnumSet<Topping> toppings;

    //////// 추상 빌더 클래스 ////////
    abstract static class Builder<T extends Builder<T>> {
        private EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        // 정적 팩터리 메서드
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // 하위 클래스는 이 메서드를 재정의(overriding)하여
        // "this" 를 반환하도록 해야 한다.
        // 클라이언트가 직접 형변환을 하지 않고
        // 하위 클래스에서 자체적으로 반환해주도록 함
        protected abstract T self();
    }
    //////////////////////////////

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}
