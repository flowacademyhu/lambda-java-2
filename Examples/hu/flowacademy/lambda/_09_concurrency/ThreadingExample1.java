package hu.flowacademy.lambda._09_concurrency;

import java.util.concurrent.atomic.AtomicInteger;

// Simples example showing execution running on two threads in parallel.
public class ThreadingExample1 {

    static String sync = "";
    static int counter = 0;

    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {


        var t1 = new Thread(
                () -> {
                    for (int i = 0; i < 100; ++i) {
                        int count = atomicInteger.incrementAndGet();
                        System.out.println("A: " + count);

                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            ;
                        }
                    }
                });

        var t2 = new Thread(
                () -> {
                    for (int i = 0; i < 100; ++i) {
                        int count = atomicInteger.incrementAndGet();
                        System.out.println("B: " + count);
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            ;
                        }
                    }
                });

        long start = System.nanoTime();
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
        long end = System.nanoTime();
        long running = end - start;
        System.out.println("Finished: " + running);
    }
}