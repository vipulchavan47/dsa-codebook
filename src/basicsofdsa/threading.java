package basicsofdsa;
class MyThread extends Thread {
    int counter = 0;
    
    public void incrementCounter(int counter) {
        this.counter = counter + 1;
        System.out.println("Counter: " + counter);
    }

    public void run() {
        System.out.println("Thread is running");
    }
}
public class threading {
    public static void main(String[] args) {
        int num = 0;
        for(int i=0;i<5;i++){
            System.out.println("Main thread: " + i);
            
            MyThread t1 = new MyThread();
            t1.start();
            t1.incrementCounter(num);
            num++;
            try {
                t1.sleep(1000);
            } catch (InterruptedException e) {
            }
        }

        for(int i=0;i<5;i++){
            System.out.println("Main thread: " + i);
            MyThread t2 = new MyThread();
            t2.start();
            t2.incrementCounter(num);
            num++;
            try {
                t2.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        
        
    }
    
}
