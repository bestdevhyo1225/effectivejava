package com.hyoseog.effectivejava.chapter2.item2;

public class CalZone extends Pizza {
    private final boolean sauceInside;

    //////// 구체 빌더 클래스 ////////
    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false;

        // 정적 팩터리 메서드
        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        public CalZone build() {
            return new CalZone(this);
        }

        // addTopping() 하고 나서 self()
        @Override
        protected Builder self() { return this; }
    }
    //////////////////////////////

    private CalZone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }
}
