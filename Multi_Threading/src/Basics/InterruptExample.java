package Basics;

import java.util.stream.IntStream;

public class InterruptExample {
    public static void main(String[] args) {
        Runnable r = ()->{
            IntStream.range(0,10).forEach(i-> {
                System.out.println("Lazy Thread");
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    System.out.println("I got Interrupted");
                }
            });
        };
        Thread thread = new Thread(r);
        thread.start();
        // Interrupting Child Thread
        thread.interrupt();
        IntStream.range(0,10).forEach(i-> System.out.println("main()"));
    }
}
