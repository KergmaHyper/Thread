import java.lang.*;

public class Main {

    public static void main(String[] args) {
      Thread t = Thread.currentThread();
        System.out.println(t.getName());
      t.setName("ThreadApplication");
        System.out.println(t.getName());
        System.out.println("wait 3000 miliseconds");
      //t.wait(3000) ;

        System.out.println(t);

    }
}
