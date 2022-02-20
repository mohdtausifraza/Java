package CutsomThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

// Custom interface for which contains execute method
// 1. Executor Class
interface MyExecutorService {
    void execute(Runnable r);
    public void shutdown();
}

// Helper Class with factory method to get instance of MyExecutorService
// 2. Executors
class MyExecutors{
    int capacity;

    // Passing the number of thread
    // that will be in the thread pool
    static MyExecutorService myNewFixedThreadPool(int capacity){
        return new MyThreadPool(capacity);
    }
}

class MyThreadPool implements MyExecutorService{

    static int capacity;
    static int currentCapacity;
    static boolean shutdownInvoked;

    static LinkedBlockingQueue<Runnable> linkedBlockingQueue;

    Execution e;
    public MyThreadPool(int capacity){
        this.capacity =capacity;
        currentCapacity=0;
        linkedBlockingQueue = new LinkedBlockingQueue<>();

        e= new Execution();
    }
    @Override
    public void execute(Runnable r) {
        shutdownInvoked=false;
        linkedBlockingQueue.add(r);

        e.executeMyMethod();
    }

    public void shutdown(){
        System.out.println("Shutting down Thread Pool");
        shutdownInvoked=true;
    }
}

class Execution implements Runnable{
    void executeMyMethod(){
        if(MyThreadPool.currentCapacity < MyThreadPool.capacity){
            MyThreadPool.currentCapacity++;

            Thread t=new Thread(new Execution());
            t.start();
        }
    }
    @Override
    public void run() {
        while(!MyThreadPool.shutdownInvoked){
            if (MyThreadPool.linkedBlockingQueue.size()!=0){
                MyThreadPool.linkedBlockingQueue.poll().run();
            }
        }
    }
}


class MyTask implements Runnable{

    @Override
    public void run() {
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Current Thread :-> "+ Thread.currentThread().getName());
    }
}

public class ExecutorServiceCustom {
    public static void main(String[] args) {
        MyExecutorService service = MyExecutors.myNewFixedThreadPool(3);
        IntStream.range(0,20).forEach(i ->{
            service.execute(new MyTask());
        });
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        service.shutdown();
    }
}
