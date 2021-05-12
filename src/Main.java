import java.lang.*;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        System.out.println("START Main ");
        Semaphore table = new Semaphore(2);

        for ( int i = 1; i < 6; i++ ) {
         new Thread(
                 new Philo(i,table) );
        }




        System.out.println("STOP Main ");

    }
}


class Philo implements Runnable {
    int ID;
    int Count = 0;
    Semaphore Sem;

    Philo( int id, Semaphore sem)
    {
        ID  = id;
        Sem = sem;
    }
    public void run(){

        while (Count<2){
            try {
                Sem.acquire();
                System.out.println("Philo"+ID+" begin lanch.");
                Thread.sleep(500);
                Count++;
                System.out.println("Philo"+ID+" out lanch zone.");
                Thread.sleep(500);
                Sem.release();
            }catch (InterruptedException e){}


        }


    }
}
