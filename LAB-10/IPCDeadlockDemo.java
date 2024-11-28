// IPC Example using wait/notify
class SharedResource {
    private int data;
    private boolean available = false;

    // Producer thread
    public synchronized void produce(int data) throws InterruptedException {
        while (available) {
            wait(); // Wait until the consumer consumes the data
        }
        this.data = data;
        System.out.println("Produced: " + data);
        available = true;
        notify(); // Notify the consumer
    }

    // Consumer thread
    public synchronized void consume() throws InterruptedException {
        while (!available) {
            wait(); // Wait until the producer produces the data
        }
        System.out.println("Consumed: " + data);
        available = false;
        notify(); // Notify the producer
    }
}

public class IPCDeadlockDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    resource.produce(i);
                    Thread.sleep(500); // Simulate time taken to produce
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    resource.consume();
                    Thread.sleep(1000); // Simulate time taken to consume
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();

        // Deadlock demonstration (Using two threads and synchronized blocks)
        Thread deadlockDemo = new Thread(() -> {
            Object lock1 = new Object();
            Object lock2 = new Object();

            // First thread trying to acquire lock1 then lock2
            Thread thread1 = new Thread(() -> {
                synchronized (lock1) {
                    System.out.println("Thread 1: Holding lock1...");
                    try { Thread.sleep(100); } catch (InterruptedException e) {}
                    System.out.println("Thread 1: Waiting for lock2...");
                    synchronized (lock2) {
                        System.out.println("Thread 1: Acquired lock2...");
                    }
                }
            });

            // Second thread trying to acquire lock2 then lock1
            Thread thread2 = new Thread(() -> {
                synchronized (lock2) {
                    System.out.println("Thread 2: Holding lock2...");
                    try { Thread.sleep(100); } catch (InterruptedException e) {}
                    System.out.println("Thread 2: Waiting for lock1...");
                    synchronized (lock1) {
                        System.out.println("Thread 2: Acquired lock1...");
                    }
                }
            });

            thread1.start();
            thread2.start();
        });

        // Start the deadlock demonstration
        deadlockDemo.start();

        // Print name at the end of the program
        System.out.println("TANMAY - 1BM23ME115");
    }
}
