package Basics;

class MyThread2 extends Thread{
    public void start(){
        System.out.println("start()");
    }
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("run()");
        }
    }
}
public class OverridingStart {
    public static void main(String[] args) {
        MyThread2 thread = new MyThread2();
        thread.start();
    }
}
