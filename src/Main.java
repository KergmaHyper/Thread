import javax.lang.model.element.Name;
import java.lang.*;

public class Main {

    public static void main(String[] args) {
      Thread t = Thread.currentThread();
        System.out.println(t.getName());
      t.setName("MAIN_ThreadApplication");
        System.out.println(t.getName());
        //System.out.println("wait 3000 miliseconds");
              System.out.println(t);

         JThread jt = new JThread("JounTreadMain");
         jt.start();
        System.out.println("ended work Thread - "+Thread.currentThread().getName());
    }
}

class JThread extends Thread {
    JThread(String Name){   super(Name);  }

    public void run(){
        System.out.println("Started thread - "+Thread.currentThread().getName());
        try {
            System.out.println("begin sleep 1000 ms");
            Thread.sleep(200);
            System.out.println("end sleep 1000 ms");
        }catch (InterruptedException ie){System.out.println(ie.getMessage());};
        System.out.println("ended work Thread - "+Thread.currentThread().getName());
    }
}