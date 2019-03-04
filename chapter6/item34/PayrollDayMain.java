package com.hyoseog.effectivejava.chapter6.item34;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PayrollDayMain {

    @Test
    public void main_test() {
        PayrollDay day = PayrollDay.MONDAY;
        int todayPay = day.pay(175, 5);

        assertThat(todayPay, is(175 * 5));
    }

}
