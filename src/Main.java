import javax.lang.model.element.Name;
import java.lang.*;

public class Main {

    public static void main(String[] args) {
      Thread t = Thread.currentThread();
        System.out.println(t.getName());
      t.setName("MAIN_ThreadApplication");
        System.out.println(t.getName());


         JThread jt = new JThread("JounTreadMain");
         jt.start();

        try{
            System.out.println(">>>>>>>>>>>>>> sleep 3000 miliseconds");
            t.sleep(3000);
            System.out.println("<<<<<<<<<<<<<< end sleep 3000 miliseconds");
        } catch (InterruptedException ie){System.out.println(ie.getMessage());}

        System.out.println(t);
        System.out.println("ended work Thread - "+Thread.currentThread().getName());
    }
}

class JThread extends Thread {
    JThread(String Name){   super(Name);  }

    public void run(){
        System.out.println(" Started thread - "+Thread.currentThread().getName());
        try {
            System.out.println(">>>>>>>>>>>>>>>> begin sleep 4000 ms");
            Thread.sleep(4000);
            System.out.println("<<<<<<<<<<<<<<<<< end sleep 4000 ms");
        }catch (InterruptedException ie){System.out.println(ie.getMessage());};
        System.out.println("ended work Thread - "+Thread.currentThread().getName());
    }
}