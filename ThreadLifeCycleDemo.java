public class ThreadLifecycleDemo {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println("Thread is running...");
            try {
                Thread.sleep(2000); // Timed Waiting
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread finished execution.");
        });

        // NEW State
        System.out.println("State after creation: " + thread.getState());

        thread.start(); // Transition to RUNNABLE
        System.out.println("State after start(): " + thread.getState());

        // Give the thread some time to move to TIMED_WAITING
        try {
            Thread.sleep(100); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State while sleeping (should be TIMED_WAITING): " + thread.getState());

        // Wait for thread to complete
        try {
            thread.join(); // Main thread waits, thread continues
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // TERMINATED State
        System.out.println("State after completion: " + thread.getState());
    }
}
