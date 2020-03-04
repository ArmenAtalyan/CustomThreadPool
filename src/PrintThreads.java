public class PrintThreads implements Runnable {

    private String name;
    private final static int THREAD_COUNT = 20;
    private int index;
    private Object lock = new Object();

    public PrintThreads(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                for (int i = 0; i < THREAD_COUNT; i++) {
                    while (index % 3 != 0) {
                       lock.wait();
                    }
                    System.out.println(name);
                    index++;
                    lock.notifyAll();
                }
            }
        } catch (Exception e) {}
    }
}
