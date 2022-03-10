package Basics;

class MyThread3 extends Thread{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Inside Child Thread");
        }
    }
}
public class MyApproachToDefineThread {
    public static void main(String[] args) {
        MyThread3 myThread = new MyThread3();
        Thread thread = new Thread(myThread);
        thread.start();
        for(int i=0;i<10;i++){
            System.out.println("Inside Main Thread");
        }
    }
}
