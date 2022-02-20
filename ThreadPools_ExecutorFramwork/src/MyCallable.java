import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    int n;

    public MyCallable(int n) {
        this.n = n;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " is finding the Sum of first "
                + n + " numbers");
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
