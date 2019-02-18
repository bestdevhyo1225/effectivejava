package com.hyoseog.effectivejava.chapter2.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

// item7. 다 쓴 객체 참조를 해제하라
// Stack 클래스는 자기 메모리를 직접 관리하기 때문에
// elemnts 배열로 저장소 풀을 만들어 원소들을 관리함..
// 배열 활성 영역에 속한 원소들이 사용되고 비활성 여역은 쓰이지 않는다.
// 가비지 컬렉터가 보기에는 비활성 영역에서 참조하는 객체도 똑같이 유효한 객체다.
// 메모리 누수에 주의하자..
public class Stack {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private Object[] elements;
    private int size = 0;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();

        // ex) size = 7 이면
        // elements[--size] => elements[6]의 원소는 더이상 사용하지 않기 때문에
        // 참조 해제 null 처리를 통해 가비지 컬렉터에 알려야 한다.
        Object result = elements[--size];
        elements[size] = null;  // 다 쓴 참조 해제
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
