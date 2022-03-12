package Basics;

import java.util.stream.IntStream;

public class YieldExample {
    public static void main(String[] args) {
        Runnable r = ()->{
            IntStream.range(0,10).forEach(i-> {
                System.out.println("run()");
                // Yielding Thread
                // Sending a thread from running state to Runnable State
                Thread.yield();
            });
        };
        Thread thread = new Thread(r);
        thread.start();
        IntStream.range(0,10).forEach(i-> System.out.println("main()"));
    }
}
