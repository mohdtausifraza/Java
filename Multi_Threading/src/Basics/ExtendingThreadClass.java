package Basics;

class MyThread extends Thread{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Inside Child Thread");
        }
    }
}
public class ExtendingThreadClass {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        for(int i=0;i<10;i++){
            System.out.println("Inside Main Thread");
        }
    }
}
