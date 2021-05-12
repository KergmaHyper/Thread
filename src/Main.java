import java.lang.*;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        System.out.println("START Main ");
        Semaphore table = new Semaphore(2);

        for ( int i = 1; i < 6; i++ ) {
         new Thread( new Philo(i,table) ).start();
        }




        System.out.println("STOP Main ");

    }
}


class Philo implements Runnable {
    int ID;
    int Count = 1;
    Semaphore Sem;

    Philo( int id, Semaphore sem)
    {
        ID  = id;
        Sem = sem;
    }
    public void run(){
      try {
        while (Count <3 )
        {
                Sem.acquire();
                System.out.println("Philo"+ID+" begin lanch "+Count);
                Thread.sleep(500);
                System.out.println("Philo"+ID+" out lanch zone "+Count);
                Sem.release();
                Thread.sleep(1000);
                Count++;
         }
       }catch (InterruptedException e){}
    }
}
