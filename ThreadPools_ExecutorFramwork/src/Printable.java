class Printable implements Runnable {

    String name;

    public Printable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " : job is started by " +
                Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println(name + " : job is Completed by " +
                Thread.currentThread().getName());
    }
} 