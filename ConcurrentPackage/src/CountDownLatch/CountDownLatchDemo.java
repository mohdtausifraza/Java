package CountDownLatch;

import java.util.concurrent.CountDownLatch;

class Worker extends Thread{
    private int delay;
    private CountDownLatch latch;

    public Worker(int delay, CountDownLatch latch, String name){
        super(name);
        this.delay=delay;
        this.latch=latch;
    }
    @Override
    public void run(){
        try{
            Thread.sleep(delay);
            latch.countDown();
            System.out.println(Thread.currentThread().getName() +": Finished");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // Let us create task that is going to wait
        // for 4 threads before it starts
        CountDownLatch latch = new CountDownLatch(4);

        // Lets Create 4 Worker Threads and start them
        Worker worker1 = new Worker(1000,latch,"Worker-1");
        Worker worker2 = new Worker(2000,latch,"Worker-2");
        Worker worker3 = new Worker(3000,latch,"Worker-3");
        Worker worker4 = new Worker(4000,latch,"Worker-4");
        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        // The main task wait for four threads
        latch.await();

        // Main Threads has started
        System.out.println(Thread.currentThread().getName()+ " :Has finished");
    }
}
