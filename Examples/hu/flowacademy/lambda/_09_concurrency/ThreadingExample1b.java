package hu.flowacademy.lambda._09_concurrency;

// Simples example showing execution running on two threads in parallel.
public class ThreadingExample1b {

    static int j = 0;

    public static void main(String[] args) throws Exception {

        var t1 = new Thread(new Runnable() {
            @Override public void run() {
                for(int i = 0; i < 1000; ++i) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    j++;
                    System.out.println("Pom1 " + j);
                }
            }
        });

        var t2 = new Thread(new Runnable() {
            @Override public void run() {
                for(int i = 0; i < 1000; ++i) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    j++;
                    System.out.println("Pom2 " + j);
                }
            }
        });

        // Threads don't start running automatically, we need to start them.
        t1.start();
        t2.start();

        // We can - but don't have to - wait until threads we started terminate.
        // We do that with the .join() method on running threads. Removing these
        // join commands will let main() exit immediately after it started the
        // threads, but you'll notice that the program doesn't exit then - it will
        // keep running until the two threads we started are done. As a general
        // rule, a Java program runs until all of its threads have exited.
        t1.join();
        t2.join();

        System.out.println("Finished");
    }
}
