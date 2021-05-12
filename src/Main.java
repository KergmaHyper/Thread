import java.lang.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("START Main ");

        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();

        System.out.println("STOP Main ");

    }
}




class Store {
    private int product=0;
    public synchronized void get() {
        while (product < 1) {
            try {
                wait();
                System.out.println("STORY EMPTY");
            } catch (InterruptedException e) {
            }
        }
            product--;
            System.out.printf("Consummer get 1 pc product from STORY\r\n");
            System.out.printf("Avalable %d pc product \r\n", product);
            notify();
        }



        public synchronized void put() {
        while (product >= 3) {
            try {
                wait();
                System.out.println("STORY FULL");
            }
            catch (InterruptedException e) {}
        }

            product++;
            System.out.printf("Produser put 1 pc product into STORE\r\n");
            System.out.printf("Avalable %d ps product\r\n",product);
            notify();

    }
}

  class Producer implements Runnable{
        Store store;
        Producer(Store store){
            this.store=store;
        }
         public void run() {
            for (int i = 1; i < 20; i++) {
                store.put();
            }
         }
    }

  class Consumer implements Runnable{
        Store store;
        Consumer(Store store){
            this.store=store;
        }
        public void run(){
            for (int i = 1;i<20;i++){
                store.get();
            }
        }
  }



