package Basics;

class MyThread1 extends Thread{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("run()");
        }
    }
    public void run(int i){
        System.out.println("run(int i)");
    }
}
public class OverloadingRun {
    public static void main(String[] args) {
        MyThread1 thread = new MyThread1();
        thread.start();
        for(int i=0;i<10;i++){
            System.out.println("Inside Main Thread");
        }
    }
}
