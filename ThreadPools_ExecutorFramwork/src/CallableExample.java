import java.util.*;
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Set<Callable<Integer>> taskList = new HashSet<>();
        taskList.add(new MyCallable(10));
        taskList.add(new MyCallable(20));
        taskList.add(new MyCallable(30));
        taskList.add(new MyCallable(40));
        taskList.add(new MyCallable(50));

        ExecutorService service = Executors.newFixedThreadPool(2);
//        Integer result = servive.invokeAny(taskList);
        List<Future<Integer>> result = service.invokeAll(taskList);
        for (Future<Integer> future : result){
            System.out.println(future.get());
        }
        service.shutdown();
    }
}
