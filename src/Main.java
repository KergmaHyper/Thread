import javax.lang.model.element.Name;
import javax.sound.midi.Track;
import java.lang.*;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Runnable rt1 = ()->{
            int i=0;
            System.out.println(">>>>>>>>>>>>>>>>> Start +++"+Thread.currentThread().getName());
            while( (!Thread.currentThread().isInterrupted()&i<10)) {
                try {
                    i++;
                    Thread.sleep(500);
                    System.out.printf("LOOP is thread %s isInterrupted %b\r\n",
                            Thread.currentThread().getName(),Thread.currentThread().isInterrupted());
                } catch (InterruptedException ie) {
                    System.out.printf("Thread %s interrupted\r\n",Thread.currentThread().getName());
                    break;
                }
            }
            System.out.println("<<<<<<<<<<<<<<<<< Stop RT1 ---"+Thread.currentThread().getName());
        };
         Thread myThr = new Thread(rt1,"MyThread");
         myThr.start();
         try {
             Thread.sleep(2000);
             myThr.interrupt();
         }catch (InterruptedException ie){System.out.println("Interrupt sleep");}

         System.out.println("STOP Main ");





       // System.out.println("!!!!!!!!!!!!!! ended work Thread !!!!!!!!!!!!- "+Thread.currentThread().getName());
    }
}

