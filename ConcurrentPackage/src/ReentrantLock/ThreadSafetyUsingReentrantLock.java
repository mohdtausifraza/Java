package ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

class Wish1 {
    ReentrantLock reentrantLock = new ReentrantLock();
    public void welcome(String name) {
        reentrantLock.lock();
        for (int i = 0; i < 10; i++) {
            System.out.print("Hello and welcome to Prolog : ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(name);
        }
        reentrantLock.unlock();
    }
}

class MyThread1 extends Thread {
    Wish1 w;
    String name;
    MyThread1(Wish1 w, String name) {
        this.w = w;
        this.name = name;
    }
    public void run() {
        w.welcome(name);
    }
}

public class ThreadSafetyUsingReentrantLock {
    public static void main(String[] args) {
        Wish1 w = new Wish1();
        MyThread1 t1 = new MyThread1(w, "Lucky");
        MyThread1 t2 = new MyThread1(w, "Ruman");
        t1.start();
        t2.start();
    }
}
