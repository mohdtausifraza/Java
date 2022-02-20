package ReentrantLock;

class Wish {
    public synchronized void welcome(String name) {
        for (int i = 0; i < 10; i++) {
            System.out.print("Hello and welcome : ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(name);
        }
    }
}

class MyThread extends Thread {
    Wish w;
    String name;
    MyThread(Wish w, String name) {
        this.w = w;
        this.name = name;
    }
    public void run() {
        w.welcome(name);
    }
}

public class ThreadSafetyUsingSync {
    public static void main(String[] args) {
        Wish w = new Wish();
        MyThread t1 = new MyThread(w, "Lucky");
        MyThread t2 = new MyThread(w, "Ruman");
        t1.start();
        t2.start();
    }
}
