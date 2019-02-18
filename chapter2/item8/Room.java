package com.hyoseog.effectivejava.chapter2.item8;

// item 8. finalizer 와 cleaner 사용을 피하라
// 내부 안전망..
// 해당 자원이 닫아야 한다면 AutoCloseable 를 반드시 구현
// Room 의 Cleaner 는 단지 안전망..
// 클라이언트가 모든 Room 생성을 try-with-resources 블록으로 감쌌다면
// 자동 청소는 전혀 필요하지 않음..
/*public class Room implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();

    // 청소가 필요한 자원. 절대 Room 을 참조해서는 안 된다!
    private static class State implements Runnable {
        int numJunkPiles;   // 방(Room) 안의 쓰레기 수

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        // close 메서드나 cleaner 가 호출 한다.
        @Override
        public void run() {
            System.out.println("방 청소");
            numJunkPiles = 0;
        }
    }

    // 방의 상태. cleanable 과 공유 한다.
    private final State state;

    // cleanable 객체. 수거 대상이 되면 방을 청소 한다.
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() {
        cleanable.clean();
    }
}*/
