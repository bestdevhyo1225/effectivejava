package com.hyoseog.effectivejava.chapter2.item9;

import java.io.*;

// item 9. try-finally 보다는 try-with-resources 를 사용하라
public class TryWithResource {
    private static final int BUFFER_SIZE = 100;

    // try-finally 보다 try-with-resources 사용
    // readLine 과 close 호출 양쪽에서 예외 발생하면, close 에서 발생한 예외는 숨겨지고
    // readLine 에서 발생한 예외가 기록된다.
    // 예외 하나만 보존되고 여러개의 다른 예외가 숨겨질 수도 있다.
    // 그러나 숨겨진 예외들도 그냥 버려지지 않고,
    // 스택 추적 내역에서 '숨겨졌다(suppressed)' 꼬리표를 달고 출력된다.
    public static String firstLineOfFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    // try-with-resource 에 catch 도 사용할 수 있다.
    // 데이터를 읽지 못했을때 예외를 던지는 대신 기본 값을 반환하도록 해봄..
    public static String firstLineFile(String path, String defaultVal) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (IOException e){
            return defaultVal;
        }
    }

    // try-finally 보다 try-with-resources 사용
    // 자원이 둘 이상인 경우에 사용하는 방법..
    public static void copy(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        }
    }
}
