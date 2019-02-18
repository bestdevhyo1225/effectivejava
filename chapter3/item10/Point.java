package com.hyoseog.effectivejava.chapter3.item10;

// 추이성
// 첫 번째 객체와 두 번째 객체가 같고, 두 번째 객체와 세 번째 객체가 같다면
// 첫 번째 객체와 세 번째 객체도 같아야 한다는 뜻
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;

        Point p = (Point)o;
        return p.x == x && p.y == y;
    }
}
