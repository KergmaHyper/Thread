import javax.lang.model.element.Name;
import javax.sound.midi.Track;
import java.lang.*;

public class Main {

    public static void main(String[] args) {

        Runnable rt1 = ()->{
            System.out.println(">>>>>>>>>>>>>>>>> Start RT1 +++"+Thread.currentThread().getName());
            try{ Thread.sleep(1000); }catch (InterruptedException ie){System.out.println("Thread interrupted");}
            System.out.println("<<<<<<<<<<<<<<<<< Stop RT1 ---"+Thread.currentThread().getName());
        };
        Runnable rt2 = ()->{
            System.out.println("``````````````````` Start RT2 +++"+Thread.currentThread().getName());
            try{ Thread.sleep(1500); }catch (InterruptedException ie){System.out.println("Thread interrupted");}
            System.out.println("''''''''''''''''''' Stop RT2 ---"+Thread.currentThread().getName());
        };
        //Thread tr1 = new Thread(rt,"tr1");
        //tr1.start();

        for (int i = 1; i<41;i++){
            Thread t = new Thread(  ((i%2)==0?rt1:rt2),"Jtread:"+i);
            t.start();
            try{
                t.join(200);
            }catch (InterruptedException ie1){System.out.println(ie1.getMessage());}
        }

       // System.out.println("!!!!!!!!!!!!!! ended work Thread !!!!!!!!!!!!- "+Thread.currentThread().getName());
    }
}

