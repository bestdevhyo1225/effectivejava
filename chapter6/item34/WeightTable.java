package com.hyoseog.effectivejava.chapter6.item34;

public class WeightTable {

    public static void main(String[] args) {
        double earthWeight = 185.d;
        double mass = earthWeight / Planet.EARTH.getSurfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.printf("%s 에서의 무게는 %f이다.\n", p, p.getSurfaceWeight(mass));
        }
    }

}
