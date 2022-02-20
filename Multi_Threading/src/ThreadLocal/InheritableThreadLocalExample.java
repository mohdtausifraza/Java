package ThreadLocal;

class ParentThread extends Thread{

    static InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal(){
        @Override
        public Object childValue(Object p){
            return "Child";
//            return p;
        }
    };

    public void run(){
        threadLocal.set("Parent");
        System.out.println("Parent Thread Value : " + threadLocal.get());
        ChildThread ct = new ChildThread();
        ct.start();
    }
}

class ChildThread extends Thread{
    public void run(){
        System.out.println("Parent Thread Value : " + ParentThread.threadLocal.get());
    }
}
public class InheritableThreadLocalExample {
    public static void main(String[] args) {
        ParentThread pt = new ParentThread();
        pt.start();
    }
}
