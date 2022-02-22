package CyclicBarrier;

import oracle.jvm.hotspot.jfr.ThreadGroupIDs;

import java.util.concurrent.*;

class Computation1 implements Runnable{

    public static int product =  0;

    @Override
    public void run()  {
        product = 2*3;
        try{
            CyclicBarrierDemo.barrier.await();
        }catch (InterruptedException | BrokenBarrierException e){
            e.printStackTrace();
        }
    }
}

class Computation2 implements Runnable{

    public static int sum =  0;

    @Override
    public void run()  {
        sum = 2+3;
        try{
            System.out.println("Is the barrier broken? - "+ CyclicBarrierDemo.barrier.isBroken());
            CyclicBarrierDemo.barrier.await(3000, TimeUnit.MILLISECONDS);
            System.out.println("Number of parties waiting at the barrier "+
                    "at this point = " + CyclicBarrierDemo.barrier.getNumberWaiting());
        }catch (InterruptedException | BrokenBarrierException | TimeoutException e){
            e.printStackTrace();
        }
    }
}
public class CyclicBarrierDemo implements Runnable{

    public static CyclicBarrier barrier = new CyclicBarrier(3);

    public static void main(String[] args) {
        CyclicBarrierDemo demo = new CyclicBarrierDemo();
        Thread t1 = new Thread(demo);
        t1.start();
    }

    @Override
    public void run() {
        System.out.println("Number of parties required to trip the barrier = "+barrier.getParties());
        System.out.println("Sum of product and sum = "+(Computation1.product+Computation2.sum));

        Computation1 comp1 = new Computation1();
        Computation2 comp2 = new Computation2();
        Thread t1=new Thread(comp1);
        Thread t2=new Thread(comp2);
        t1.start();
        t2.start();

        try{
            barrier.await();
        }catch (InterruptedException | BrokenBarrierException e){
            e.printStackTrace();
        }

        System.out.println("Sum of product and sum = "+(Computation1.product+Computation2.sum));

        // Resetting the barrier
        barrier.reset();
        System.out.println("Barrier reset successfully");
    }
}
