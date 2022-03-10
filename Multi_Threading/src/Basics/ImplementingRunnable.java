package Basics;

class MyRunnable implements Runnable{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Inside Child Thread");
        }
    }
}
public class ImplementingRunnable {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        for(int i=0;i<10;i++){
            System.out.println("Inside Main Thread");
        }
    }
}
