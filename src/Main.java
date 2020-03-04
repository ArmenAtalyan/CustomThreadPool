import java.util.*;

public class Main {

    public static void main(String[] args) {
//        Thread t1 = new Thread(new PrintThreads("Vardan", 0));
//        Thread t2 = new Thread(new PrintThreads("Aram", 1));
//        Thread t3 = new Thread(new PrintThreads("Lilit", 2));
//        t1.start();
//        t2.start();
//        t3.start();

        CustomThreadPool pool = new CustomThreadPool(7);

        for(int i = 0; i < 7; i++){
            TasksQueue task = new TasksQueue(i);
            pool.addTask(task);
        }
    }
}
