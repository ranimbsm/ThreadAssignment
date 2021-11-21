
public class ThreadAssignment {

    static class Counter {
        void count() {
            //todo implement me
            for (int i = 350; i > 0; i--) {
                System.out.println(i);
            }
            System.out.println("Finish!");
        }

    }
    static class MyThread extends Thread {
        private final Counter counter;

        public MyThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            synchronized (counter) {
                counter.count();
                counter.notify();
            }


        }



        public static void main(String[] args) throws InterruptedException {
            Counter counter = new Counter();

           MyThread t1= new MyThread(counter);
           MyThread t2= new MyThread(counter);
           t1.start();
           t2.start();
           try{
            t1.join();
            t2.join();}
           catch(InterruptedException exc) {}

            System.out.println("Done !")   ;
        }
    }}