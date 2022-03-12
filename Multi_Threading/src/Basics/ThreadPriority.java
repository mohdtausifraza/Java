package Basics;

import java.util.stream.IntStream;

class MyThread4 extends Thread{
    public void run(){
        IntStream.range(0,10).forEach(i-> System.out.println("run()"));
    }
}
public class ThreadPriority {
    public static void main(String[] args) {
        MyThread4 thread = new MyThread4();
        thread.setPriority(10);
        thread.start();
        IntStream.range(0,10).forEach(i-> System.out.println("main()"));
    }
}
