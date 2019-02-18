package com.hyoseog.effectivejava.chapter3.item10;

// 대칭성(Symmetry)
// null 이 아닌 모든 참조 값 x, y에 대해
// x.equal(y)가 true 이면 y.equal(x) 도 true 다.
// 두 객체는 서로에 대한 동치 여부에 똑같이 답해야 한다는 뜻..

import java.util.Objects;

// 다음은 대칭성이 위배되는 코드..
public final class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    // 대칭성 위배!
    @Override
    public boolean equals(Object o) {
        /*if (o instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);

        // 한 방향으로만 작동한다!!
        if (o instanceof String)
            return s.equalsIgnoreCase((String) o);

        return false;*/

        return o instanceof CaseInsensitiveString &&
                ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }
}
