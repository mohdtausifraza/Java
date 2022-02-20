package ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class MyThread3 extends Thread {
    static ReentrantLock reentrantLock = new ReentrantLock();
    public MyThread3(String name) {
        super(name);
    }
    public void run() {
        do {
            try {
                if (reentrantLock.tryLock(5000, TimeUnit.MILLISECONDS)) {
                    System.out.println(Thread.currentThread().getName() + ": got the lock");
                            Thread.sleep(30000);
                    reentrantLock.unlock();
                    System.out.println(Thread.currentThread().getName() + " released the lock");
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + " : did not got the lock will try again");
                }
            } catch (InterruptedException e) {   }
        } while (true);
    }
}
public class TryLockExample2 {
    public static void main(String[] args) {
        MyThread3 t1 = new MyThread3("First Thread");
        MyThread3 t2 = new MyThread3("Second Thread");
        t1.start();
        t2.start();
    }
}
