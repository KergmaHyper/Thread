import java.lang.*;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        System.out.println("START Main ");
        Exchanger<String> ex1 = new Exchanger<String>();
        new Thread(new Change(ex1,"Thread1","Message1 from Thread1")).start();
        new Thread(new Change(ex1,"Thread2","Message2 from Thread2")).start();
        new Thread(new Change(ex1,"Thread3","Message3 from Thread3")).start();
        new Thread(new Change(ex1,"Thread4","Message4 from Thread4")).start();
        new Thread(new Change(ex1,"Thread5","Message5 from Thread5")).start();
        System.out.println("STOP Main ");
    }
}
class Change implements Runnable{
    Exchanger<String> exchanger;
    String message;
    String name;

    Change(Exchanger exchanger,String name,String message){
        this.message=message;
        this.exchanger=exchanger;
        this.name = name;    }

    public void run(){
       try {
           System.out.printf("Old message \"%s\" from %s\r\n", message, name);
           message = exchanger.exchange(message);

           System.out.printf("New message \"%s\" from %s\r\n", message, name);
       }catch (InterruptedException e){System.out.println("Interrupt from "+name);}
       }


}