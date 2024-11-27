class MessageThread extends Thread {
    private String message;
    private int interval;

    public MessageThread(String message, int interval) {
        this.message = message;
        this.interval = interval;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(message);
                Thread.sleep(interval * 1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) {
        new MessageThread("BMS College of Engineering", 10).start();
        new MessageThread("CSE", 2).start();
    }
}
