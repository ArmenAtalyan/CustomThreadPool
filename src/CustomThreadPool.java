import java.util.LinkedList;

public class CustomThreadPool {

    private LinkedList<Runnable> tasksList;
    private WorkingThreads[] threads;

    public CustomThreadPool(int numThreads) {
        tasksList = new LinkedList<>();
        threads = new WorkingThreads[numThreads];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new WorkingThreads();
            threads[i].start();
        }
    }

    public void addTask(Runnable task) {
        synchronized (tasksList) {
            tasksList.addLast(task);
            tasksList.notify();
        }
    }

    private class WorkingThreads extends Thread {
        Runnable task;

        public void run() {
            synchronized (tasksList) {
                while (tasksList.isEmpty()) {
                    try {
                        tasksList.wait();
                    } catch (InterruptedException e) {}
                }
                task = tasksList.poll();
            }
            try {
                task.run();
            }catch (Exception e){}
        }
    }
}
