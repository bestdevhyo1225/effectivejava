package com.hyoseog.effectivejava.chapter6.item34;

public enum PayrollDay {

    MONDAY(PayType.WEEKDAY), TUESDAY(PayType.WEEKDAY), WENDNESDAY(PayType.WEEKDAY), THURSDAY(PayType.WEEKDAY), FRIDAY(PayType.WEEKDAY),
    SATURDAY(PayType.WEEKAND), SUNDAY(PayType.WEEKAND);

    private final PayType payType;

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    public int pay(int minuteWorked, int payRate) {
        // 잔업 수당 계산을 PayType 에서 해준다.
        return this.payType.pay(minuteWorked, payRate);
    }

    // 전략 열거 타입
    // 잔업 수당 계산을 PayType 에서 해준다.
    enum PayType {
        // 기존 switch 문에서 분리하여 overtimePay 를 계산하는 부분을 상수에 넣기
        WEEKDAY {
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked <= MINS_PER_SHIFT ?
                        0 : (minsWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKAND {
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked * payRate / 2;
            }
        };

        abstract int overtimePay(int mins, int payRate);

        private static final int MINS_PER_SHIFT = 8 * 60;

        int pay(int minsWorked, int payRate) {
            int basePay = minsWorked * payRate;
            return basePay + overtimePay(minsWorked, payRate);
        }

    }

}
