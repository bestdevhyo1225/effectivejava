package com.hyoseog.effectivejava.chapter2.item2;

import java.util.Objects;

public class NyPizza extends Pizza {
    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }

    private final Size size;

    //////// 구체 빌더 클래스 ////////
    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }

        // addTopping 하고 나서 self() 반환
        @Override
        protected Builder self() { return this; }
    }
    //////////////////////////////

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}
