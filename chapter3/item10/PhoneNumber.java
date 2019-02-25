package com.hyoseog.effectivejava.chapter3.item10;

public final class PhoneNumber {
    private final short areaCode, prefix, lineNum;
    private int hashCode; // 자동으로 0으로 초기화

    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = rangeCheck(areaCode,999, "지역코드");
        this.prefix = rangeCheck(prefix, 999, "프리픽스");
        this.lineNum = rangeCheck(lineNum, 9999, "가입자 번호");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);

        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        // 1. == 연산자를 사용해 입력이 자기 자신의 참조인지 확인한다.
        if (o == this)
            return true;

        // 2. instanceof 연산자로 입력이 올바른 타입인지 확인한다.
        if (!(o instanceof PhoneNumber))
            return false;

        // 3. 입력을 올바른 타입으로 형변환한다.
        PhoneNumber pn = (PhoneNumber) o;

        // 4. 입력 객체와 자기 잣긴의 대응되는 '핵심' 필드들이 모두 일치하는지 하나씩 검사한다.
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    // Item 11. equals 를 재정의 했다면 hashcode 도 재정의할 것
    // 여러가지 방법이 있지만..
    // 클래스가 불변이고 해시코드를 계산하는 비용이 크다면, 매번 새로 계산하기 보다는
    // 캐싱하는 방식을 고려해야함.
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = Short.hashCode(areaCode);
            result = 31 * result + Short.hashCode(prefix);
            result = 31 * result + Short.hashCode(lineNum);
            hashCode = result;
        }
        return result;
    }
}
