import java.lang.*;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        System.out.println("START Main ");
        Semaphore sem1 = new Semaphore(3,true);
        CommonResource comres1 = new CommonResource();

        new Thread( new Count(comres1,sem1,"Thread1",1)).start();
        new Thread( new Count(comres1,sem1,"Thread2",10)).start();
        new Thread( new Count(comres1,sem1,"Thread3",100)).start();
        new Thread( new Count(comres1,sem1,"Thread4",1000)).start();


        System.out.println("STOP Main ");

    }
}

class CommonResource{
    int x=0;
}

class Count implements Runnable{
    CommonResource res;
    Semaphore sem;
    String name;
    int count;
    Count(CommonResource res,Semaphore sem, String name, int count){
        this.res=res;
        this.sem=sem;
        this.name=name;
        this.count=count;
    }
    public void run(){
        try{
            System.out.println("Request access CommonResurce from "+this.name);
            sem.acquire();
            for (int i=1;i<10;i++){
               res.x+=count;
               System.out.println(this.name+":"+res.x);
            }

        }catch (InterruptedException e){}
        System.out.println("Release access CommonResource from "+this.name);
        sem.release();
    }



}