package ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

class MyThread2 extends Thread {
    static ReentrantLock reentrantLock = new ReentrantLock();
    public MyThread2(String name) {
        super(name);
    }
    public void run() {
        if (reentrantLock.tryLock()) {
            System.out.println(Thread.currentThread().getName() + ": got the lock and performing safe operation");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            }
            reentrantLock.unlock();
        } else {
            System.out.println(Thread.currentThread().getName() + " : did not got the lock hence performing alternate operation");
        }
    }
}
public class TryLockExample1 {
    public static void main(String[] args) {
        MyThread2 t1 = new MyThread2("First Thread");
        MyThread2 t2 = new MyThread2("Second Thread");
        t1.start();
        t2.start();
    }
}
