import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        Printable jobs[] = {
                new Printable("Lucky"),
                new Printable("Ruman"),
                new Printable("Shayan"),
                new Printable("Waffy"),
                new Printable("Raza"),
                new Printable("Tausif")
        };
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        for (Printable job : jobs) {
            threadPoolExecutor.submit(job);
        }
        threadPoolExecutor.shutdown();
    }
}
