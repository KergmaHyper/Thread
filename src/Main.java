import java.lang.*;

public class Main {

    public static void main(String[] args) {
      Thread t = Thread.currentThread();
        System.out.println(t.getName());
      t.setName("ThreadApplication");
        System.out.println(t.getName());
        try{
            System.out.println("sleep 3000 miliseconds");
            t.sleep(3000);
            System.out.println("end sleep 3000 miliseconds");
        } catch (InterruptedException ie){System.out.println(ie.getMessage());}

        System.out.println(t);

    }
}
