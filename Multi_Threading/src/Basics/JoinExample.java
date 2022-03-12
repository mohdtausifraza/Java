package Basics;

import java.util.stream.IntStream;

public class JoinExample {
    public static void main(String[] args) {
        Runnable r = ()->{
            IntStream.range(0,10).forEach(i-> {
                System.out.println("run()");
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){ }
            });
        };
        Thread thread = new Thread(r);
        thread.start();
        // Joining child thread to main thread.
        try{
            thread.join();
        }catch (InterruptedException e){ }
        IntStream.range(0,10).forEach(i-> System.out.println("main()"));
    }
}
