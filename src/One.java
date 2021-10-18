class Second  implements Runnable{
    private String name;
    Thread t ;
    Second(String threadname){
        name = threadname;
        t = new Thread(this,name);
        System.out.println("New thread created: " + t);
        t.start();
    }
    public void run(){
        try{
            for(int i = 5;i > 0; i--){
                System.out.println(name +": " + i);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            System.out.println(name + " thread interrupted");
        }
        System.out.println(name + " thread off");
    }
}

public class One {
    public static void main(String...args){
        Second ob1 = new Second("one");
        Second ob2 = new Second("two");
        Second ob3 = new Second("three");

        System.out.println("Thread one alive: " + ob1.t.isAlive());
        System.out.println("Thread one alive: " + ob2.t.isAlive());
        System.out.println("Thread one alive: " + ob3.t.isAlive());

        try{
            System.out.println("waiting for threads off");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();

        }catch(InterruptedException e){
            System.out.println("Main thread interrapted");
        }
        System.out.println("Thread one alive: " + ob1.t.isAlive());
        System.out.println("Thread one alive: " + ob2.t.isAlive());
        System.out.println("Thread one alive: " + ob3.t.isAlive());

        System.out.println("Main thread off");
    }
}
