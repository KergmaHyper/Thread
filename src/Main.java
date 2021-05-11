import javax.lang.model.element.Name;
import javax.sound.midi.Track;
import java.lang.*;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Runnable rt1 = ()->{
            System.out.println(">>>>>>>>>>>>>>>>> Start ODD RT1 +++"+Thread.currentThread().getName());
            try{ Thread.sleep(1000); }catch (InterruptedException ie){System.out.println("Thread interrupted");}
            System.out.println("<<<<<<<<<<<<<<<<< Stop RT1 ---"+Thread.currentThread().getName());
        };
        Runnable rt2 = ()->{
            System.out.println("``````````````````` Start NOT ODD RT2 +++"+Thread.currentThread().getName());
            try{ Thread.sleep(1500); }catch (InterruptedException ie){System.out.println("Thread interrupted");}
            System.out.println("''''''''''''''''''' Stop RT2 ---"+Thread.currentThread().getName());
        };
        Predicate<Integer> odd = (x)->(x%2)==0;

        for (int i = 1; i<41;i++){
            Thread t = new Thread(  (odd.test(i)?rt1:rt2),"Jtread:"+i);
            t.start();
            try{
                t.join(200);
            }catch (InterruptedException ie1){System.out.println(ie1.getMessage());}
        }

       // System.out.println("!!!!!!!!!!!!!! ended work Thread !!!!!!!!!!!!- "+Thread.currentThread().getName());
    }
}

