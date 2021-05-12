import java.lang.*;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        System.out.println("START Main ");
        Phaser phaser1 =new Phaser(1);
        new Thread(new PhaseThr(phaser1,"Thread1",500)).start();
        new Thread(new PhaseThr(phaser1,"Thread2",1500)).start();
        new Thread(new PhaseThr(phaser1,"Thread3",2100)).start();
        new Thread(new PhaseThr(phaser1,"Thread4",800)).start();

        System.out.println("Main: Work in phase: "+phaser1.getPhase());
        phaser1.arriveAndAwaitAdvance();
        System.out.println("Main: Work in phase: "+phaser1.getPhase());
        phaser1.arriveAndAwaitAdvance();
        System.out.println("Main: Work in phase: "+phaser1.getPhase());
        phaser1.arriveAndDeregister();
        System.out.println("Main:  END ALL PHASES "+phaser1.getPhase());



        System.out.println("STOP Main ");
    }
}
class PhaseThr implements Runnable{
    Phaser phaser;
    String name;
    int sleepTime;
    PhaseThr(Phaser phaser,String name,int sleepTime){
        this.phaser=phaser;
        this.name = name;
        this.sleepTime=sleepTime;
        phaser.register();}

    public void run(){

        System.out.println("Thread: "+name+" working in phase: "+phaser.getPhase());
        phaser.arriveAndAwaitAdvance();
       try {
          Thread.sleep(sleepTime);
       }catch (InterruptedException e){System.out.println("Interrupt from "+name);}
       //phaser.arriveAndAwaitAdvance();

        System.out.println("Thread: "+name+" working in phase: "+phaser.getPhase());
        phaser.arriveAndAwaitAdvance();
        try {
            Thread.sleep(sleepTime);
        }catch (InterruptedException e){System.out.println("Interrupt from "+name);}
        //phaser.arriveAndAwaitAdvance();

        System.out.println("Thread: "+name+" working in phase: "+phaser.getPhase());
        phaser.arriveAndDeregister();
        try {
            Thread.sleep(sleepTime);
        }catch (InterruptedException e){System.out.println("Interrupt from "+name);}
        //phaser.arriveAndDeregister();


       }


}