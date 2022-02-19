package ThreadGroup;

class MyThread extends Thread{
    public MyThread(ThreadGroup g, String name) {
        super(g, name);
    }
    @Override
    public void run() {
        System.out.println("Child Thread");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }
}
public class ActiveThreadAndGroupCount {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup parent = new ThreadGroup("ParentGroup");
        ThreadGroup child = new ThreadGroup(parent, "ChildGroup");
        MyThread t1 = new MyThread(parent, "Child Thread-1");
        MyThread t2 = new MyThread(parent, "Child Thread-2");
        t1.start();
        t2.start();
        System.out.println(parent.activeCount());        //2
        System.out.println(parent.activeGroupCount());    //1
        parent.list();
        Thread.sleep(10000);
        System.out.println(parent.activeCount());        //0
        System.out.println(parent.activeGroupCount());    //1
        parent.list();
    }
}
