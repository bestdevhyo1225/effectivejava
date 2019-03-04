package com.hyoseog.effectivejava.chapter6.item34;

public class OperationMain {

    public static void main(String[] args) {
        double x = 2.d;
        double y = 4.d;

        for (Operation op : Operation.values()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
            System.out.println(Operation.fromString(op.toString()));
        }

    }

}
