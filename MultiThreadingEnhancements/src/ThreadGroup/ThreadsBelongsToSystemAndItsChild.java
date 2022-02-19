package ThreadGroup;

public class ThreadsBelongsToSystemAndItsChild {
    public static void main(String[] args) {
        ThreadGroup system=Thread.currentThread().getThreadGroup().getParent();
        Thread[] allThreads=new Thread[system.activeCount()];
        system.enumerate(allThreads);
        for (Thread t: allThreads) {
            System.out.println(t.getName()+"-------"+t.isDaemon());
        }
    }
}
