package Basics;

public class GetSetThreadName {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setName("Tausif");
        System.out.println(Thread.currentThread().getName());
    }
}
