package ForkJoin;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;

public class SumAction extends RecursiveAction {
    private static final int SEQUENTIAL_THRESHOLD = 5;

    private List<Long> data;
    public SumAction(List<Long> data){
        this.data=data;
    }

    @Override
    protected void compute() {
        // Base Case
        if (data.size() <=SEQUENTIAL_THRESHOLD){
            long sum = computeSumDirectly();
            System.out.format("Sum of %s: %d %n", data.toString(),sum);
        }
        // Recursive Case
        // calculate new Range
        else{
            int mid = data.size()/2;
            SumAction firstSubTask = new SumAction(data.subList(0,mid));
            SumAction secondSubTask = new SumAction(data.subList(mid,data.size()));

            firstSubTask.fork();        // Queue the first task
            secondSubTask.compute();    // Compute the second Task
            firstSubTask.join();        // Wait for the first task result

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
        SumAction task = new SumAction(data);
        pool.invoke(task);
    }
}
