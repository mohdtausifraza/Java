package ThreadGroup;

public class SystemGroupDetails {
    public static void main(String[] args) {
        ThreadGroup parentGroup = Thread.currentThread().getThreadGroup().getParent();
        parentGroup.list();
    }
}
