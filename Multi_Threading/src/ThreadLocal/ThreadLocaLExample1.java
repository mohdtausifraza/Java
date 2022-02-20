package ThreadLocal;

public class ThreadLocaLExample1 {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal=new ThreadLocal<>();
        System.out.println(threadLocal.get());
        threadLocal.set("Tausif");
        System.out.println(threadLocal.get());
        threadLocal.remove();
        System.out.println(threadLocal.get());
    }
}
