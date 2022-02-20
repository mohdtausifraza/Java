package BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.IntStream;

class Message{
    private String msg;

    public Message(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }
}

class Producer implements Runnable{
    private BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        // Produce Message
        IntStream.range(0,100).forEach( i->{
             Message msg = new Message(""+i);
             try{
                 Thread.sleep(i);
                 queue.put(msg);
                 System.out.println("Produced :"+msg.getMsg());
             }catch (InterruptedException e){
                 e.printStackTrace();
             }
        });
        // Adding exit message
        Message msg = new Message("Exit");
        try{
            queue.put(msg);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{
    private BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            Message msg;
            while((msg=queue.take()).getMsg()!="Exit"){
                Thread.sleep(100);
                System.out.println("Consumed" + msg.getMsg());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class ProducerConsumerService {
    public static void main(String[] args) {
        // Creating Blocking Queue of Size 10
        BlockingQueue<Message> queue = new ArrayBlockingQueue<Message>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        // Starting Producer to produce message to Queue
        new Thread(producer).start();
        // Starting Consumer to consume message from Queue
        new Thread(consumer).start();
        System.out.println("Producer Consumer has been started");
    }
}
