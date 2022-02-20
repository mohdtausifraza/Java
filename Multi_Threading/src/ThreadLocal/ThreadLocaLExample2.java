package ThreadLocal;

public class ThreadLocaLExample2 {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal=new ThreadLocal(){
            public Object initialValue(){
                return "myDefaultValue";
            }
        };
        System.out.println(threadLocal.get());
        threadLocal.set("Tausif");
        System.out.println(threadLocal.get());
        threadLocal.remove();
        System.out.println(threadLocal.get());
    }
}
