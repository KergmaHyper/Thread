import javax.lang.model.element.Name;
import java.lang.*;

public class Main {

    public static void main(String[] args) {


        for (int i = 1; i<41;i++){
            JThread t = new JThread("Jtread-"+i,i);
            t.start();
            try{
                t.join(200);
            }catch (InterruptedException ie1){System.out.println(ie1.getMessage());}
        }

        System.out.println("!!!!!!!!!!!!!! ended work Thread !!!!!!!!!!!!- "+Thread.currentThread().getName());
    }
}

class JThread extends Thread {
    int sec;
    JThread(String Name, int Sec){   super(Name); this.sec=Sec*200+1000; }

    public void run(){
        try {
            System.out.printf(">>>>>>>>>>>>>>>> begin sleep %d ms thread %s\r\n",sec,Thread.currentThread().getName());
            Thread.sleep(sec);
            System.out.printf("<<<<<<<<<<<<<<<<< end sleep %d ms thread %s\r\n",sec,Thread.currentThread().getName());
        }catch (InterruptedException ie){System.out.println(ie.getMessage());};
         }
}