package ForkJoin;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class SumTask extends RecursiveTask<Long> {
    private static final int SEQUENTIAL_THRESHOLD = 5;

    private List<Long> data;
    public SumTask(List<Long> data){
        this.data=data;
    }

    @Override
    protected Long compute() {
        // Base Case
        if (data.size() <=SEQUENTIAL_THRESHOLD){
            long sum = computeSumDirectly();
            System.out.format("Sum of %s: %d %n", data.toString(),sum);
            return sum;
        }
        // Recursive Case
        // calculate new Range
        else{
            int mid = data.size()/2;
            SumTask firstSubTask = new SumTask(data.subList(0,mid));
            SumTask secondSubTask = new SumTask(data.subList(mid,data.size()));

            firstSubTask.fork();        // Queue the first task
            // Return the sum of all subtask
            return secondSubTask.compute() + firstSubTask.join();

            //Or Simply Call
            //invokeAll(firstSunTask, secondSubtask);
        }
    }

    private long computeSumDirectly(){
        long sum=0;
        for(Long l: data){
            sum+=l;
        }
        return sum;
    }

    public static void main(String[] args) {
        Random random = new Random();
        List<Long> data = random
                .longs(10,1,5)
                .boxed()
                .collect(Collectors.toList());

        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(data);
        long sum = pool.invoke(task);
        System.out.println("Sum = "+sum);
    }
}
