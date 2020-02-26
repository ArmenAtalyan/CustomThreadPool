public class TasksQueue implements Runnable {

    private int number;

    public TasksQueue(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(number + " thread is running.");
    }
}
