import java.lang.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("START Main ");

       /* Runnable rt1 = ()->{
            int i=0;
            System.out.println(">>>>>>>>>>>>>>>>> Start +++"+Thread.currentThread().getName());
            while( (!Thread.currentThread().isInterrupted()&i<10)) {
                try { i++;
                    Thread.sleep(500);
                    System.out.printf("LOOP is thread %s isInterrupted %b\r\n",
                            Thread.currentThread().getName(),Thread.currentThread().isInterrupted());
                } catch (InterruptedException ie) {
                    System.out.printf("Thread %s interrupted\r\n",Thread.currentThread().getName());
                    break;  } }
            System.out.println("<<<<<<<<<<<<<<<<< Stop RT1 ---"+Thread.currentThread().getName()); };


         mThread myThr = new mThread("My_TEST_Thread");
         myThr.start();
         try { Thread.sleep(46);
             myThr.interrupt();
         }catch (InterruptedException ie){System.out.println("Interrupt sleep");}
*/
        CommRes MainCR = new CommRes();
        for(int t=0;t<8;t++) {
            Thread NewTh = new Thread(new runThr(MainCR));
            NewTh.setName("MainCR"+t);
            NewTh.start();
            //try {NewTh.join();}catch (InterruptedException e){};
        }

        System.out.println("STOP Main ");

    }
}

class CommRes {
    int x;

    synchronized void  xout(){

          for (x=0; x<5;x++){
          System.out.printf("%s %d\n",Thread.currentThread().getName(),this.x);
          try {Thread.sleep(200);  }catch (InterruptedException e){}
          }
    }
}

class runThr implements Runnable{
    CommRes CR;
    runThr(CommRes cr){CR = cr;}

    public void run(){  CR.xout();  }
}













class mThread extends Thread{
    mThread(String name){super(name);}

    public void run(){
        System.out.println("Start thread: "+getName());
        int count=0;
        while (!isInterrupted()){
            System.out.println("Loop from: "+getName()+" count: "+ count++ + " Interrupt: "+isInterrupted());
        }
        System.out.println("Stop thread: "+getName());
    }
}