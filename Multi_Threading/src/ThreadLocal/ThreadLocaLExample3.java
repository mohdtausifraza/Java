package ThreadLocal;

class EmployeeThread extends Thread {
    static Integer empId = 0;

    public EmployeeThread(String threadName) {
        super(threadName);
    }

    ThreadLocal<Integer> threadLocal = new ThreadLocal() {
        public Object initialValue() {
            return ++empId;
        }
    };

    public void run() {
        System.out.println(Thread.currentThread().getName() + " is executing with id=" + threadLocal.get());
    }


}

public class ThreadLocaLExample3 {
    public static void main(String[] args) {
        EmployeeThread t1 = new EmployeeThread("Employee Thread-1");
        EmployeeThread t2 = new EmployeeThread("Employee Thread-2");
        EmployeeThread t3 = new EmployeeThread("Employee Thread-3");
        EmployeeThread t4 = new EmployeeThread("Employee Thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
